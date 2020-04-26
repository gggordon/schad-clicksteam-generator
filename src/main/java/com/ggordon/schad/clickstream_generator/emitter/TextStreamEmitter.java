package com.ggordon.schad.clickstream_generator.emitter;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ggordon.schad.clickstream_generator.generators.IGenerator;

public class TextStreamEmitter {
	private Logger logger = LogManager.getLogger(TextStreamEmitter.class);
	protected int port;
	protected int streamInterval;
	protected int maxConcurrentClients;
	protected String dataDelimiter;
	protected IGenerator generator;
	private ServerSocket servSocket;
	private Thread serverJobThread;
	
	public TextStreamEmitter(
			int port, 
			IGenerator generator,
			int streamInterval) {
		this(port,generator,streamInterval,30);
	}
	
	public TextStreamEmitter(
			int port, 
			IGenerator generator,
			int streamInterval,
			int maxConcurrentClients) {
		this(port,generator,streamInterval,maxConcurrentClients,"|");
	}
	
	public TextStreamEmitter(
			int port, 
			IGenerator generator,
			int streamInterval,
			int maxConcurrentClients,
			String dataDelimiter) {
		super();
		this.port = port;
		this.generator = generator;
		this.streamInterval = streamInterval;
		this.maxConcurrentClients = maxConcurrentClients;
		this.dataDelimiter = dataDelimiter;
	}
	
	public void start() throws IOException {
		stop();
		servSocket = new ServerSocket(port, maxConcurrentClients);
		logger.debug("Starting server thread on port "+port);
		serverJobThread = new Thread(new Runnable() {

			public void run() {
				ThreadPoolExecutor clientThreadPool = 
						new ThreadPoolExecutor(
								maxConcurrentClients-10,
								maxConcurrentClients, 3000, 
								TimeUnit.MILLISECONDS, 
								new ArrayBlockingQueue<Runnable>(
										maxConcurrentClients-10
										)
								);
				
				
				while(true) {
					if(servSocket ==null || 
					   servSocket.isClosed() || 
					   Thread.interrupted()) {
						clientThreadPool.shutdownNow();
						break;
					}
					try {
						
						Socket client = servSocket.accept();
						logger.debug("New client acknowledged");
						final PrintStream ps = new PrintStream(client.getOutputStream());
						clientThreadPool.execute(new Runnable() {

							public void run() {
								while(true) {
									try {
									ps.println(generator.getRandomRecord(dataDelimiter));
									try {
										Thread.sleep(streamInterval);
									} catch (InterruptedException e) {
										logger.error(e);
									}
									}catch(Exception e) {
										logger.error(e);
										break;
									}
								}
								
							}
							
						});
						
					} catch (IOException e) {
						
						logger.error(e);
					}
						
						
				}
				
			}
			
		});
		serverJobThread.start();
	}
	
	public void stop() {
		try {
			if(servSocket != null && !servSocket.isClosed()) {
				serverJobThread.interrupt();				
				servSocket.close();
				
				
			}
			servSocket = null;
		}catch(IOException e) {
			logger.error(e);
		}
	}
	
	
	
	
	
	

}
