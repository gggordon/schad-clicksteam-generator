package com.ggordon.schad.clickstream_generator.emitter;

import com.ggordon.schad.clickstream_generator.formatters.SimpleTextFormatter;
import com.ggordon.schad.clickstream_generator.generators.IGenerator;

public class TextStreamEmitter
extends StreamEmitter {

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
		super(port,generator,streamInterval,maxConcurrentClients,new SimpleTextFormatter());
	}
	

}
