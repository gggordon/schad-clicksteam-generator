package com.ggordon.schad.clickstream_generator.emitter;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.ggordon.schad.clickstream_generator.generators.IGenerator;

public class TextStreamEmitter {
	protected int port;
	protected int streamInterval;
	protected IGenerator generator;
	private ServerSocket servSocket;
	
	public TextStreamEmitter(
			int port, 
			IGenerator generator,
			int streamInterval) {
		super();
		this.port = port;
		this.generator = generator;
		this.streamInterval = streamInterval;
	}
	
	public void start() throws IOException {
		servSocket = new ServerSocket(port, 30);
		Thread t = new Thread(new Runnable() {

			public void run() {
				while(true) {
					if(servSocket ==null || servSocket.isClosed()) {
						break;
					}
					try {
						Socket client = servSocket.accept();
						System.out.println("New client");
						final PrintStream ps = new PrintStream(client.getOutputStream());
						Thread clientThread = new Thread(new Runnable() {

							public void run() {
								while(true) {
									try {
									ps.println(generator.getRandomRecord("|"));
									try {
										Thread.sleep(streamInterval);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									}catch(Exception e) {
										e.printStackTrace();
										break;
									}
								}
								
							}
							
						});
						clientThread.start();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
						
						
				}
				
			}
			
		});
		t.start();
	}
	
	public void stop() {
		try {
			if(servSocket != null && !servSocket.isClosed()) {
				servSocket.close();
				
			}
			servSocket = null;
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	

}
