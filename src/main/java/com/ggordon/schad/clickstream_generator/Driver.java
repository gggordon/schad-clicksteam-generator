package com.ggordon.schad.clickstream_generator;

import java.io.IOException;

import com.ggordon.schad.clickstream_generator.cli.CliArgumentParser;
import com.ggordon.schad.clickstream_generator.emitter.TextStreamEmitter;
import com.ggordon.schad.clickstream_generator.generators.ClickStreamGenerator;

public class Driver {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = CliArgumentParser.getPort(args, 3005);
		int interval = CliArgumentParser.getInterval(args, 800);
		System.out.println(String.format("Running Emitter on Port %d every %d milli-seconds",port,interval));
		
		TextStreamEmitter emitter = new TextStreamEmitter(
				port, 
				new ClickStreamGenerator(), 
				interval
				);
		try {
			emitter.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
