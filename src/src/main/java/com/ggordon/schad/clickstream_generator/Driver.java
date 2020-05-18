package com.ggordon.schad.clickstream_generator;

import java.io.IOException;

import com.ggordon.schad.clickstream_generator.cli.CliArgumentParser;
import com.ggordon.schad.clickstream_generator.emitter.JSONStreamEmitter;
import com.ggordon.schad.clickstream_generator.emitter.StreamEmitter;
import com.ggordon.schad.clickstream_generator.emitter.TextStreamEmitter;
import com.ggordon.schad.clickstream_generator.generators.ClickStreamGenerator;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = CliArgumentParser.getPort(args, 3005);
		int interval = CliArgumentParser.getInterval(args, 800);
		String outputFormat = CliArgumentParser.getOutputFormat(args, "json");
		System.out.println(String.format("Running Emitter on Port %d every %d milli-seconds using format %s", port, interval,outputFormat));

		
		StreamEmitter emitter = outputFormat.equals("text")
				? new TextStreamEmitter(port, new ClickStreamGenerator(), interval)
				: new JSONStreamEmitter(port, new ClickStreamGenerator(), interval);
		try {
			emitter.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
