package com.ggordon.schad.clickstream_generator.cli;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Helper class to extract Cli Arguments
 * */
public class CliArgumentParser {
	private static final Logger logger = LogManager.getLogger(CliArgumentParser.class);
	public static String PORT_PREFIX="--port=";
	public static String EMIT_INTERVAL_PREFIX="--interval=";
	public static String EMIT_OUTPUTFORMAT_PREFIX="--output-format=";
	/**
	 * Extracts port number if provided in the format
	 *   --port=3005
	 *   
	 * @param args - String arguments accepted from the cli
	 * @param defaultPort default port in the event that one was not specified
	 * */
    public static int getPort(String[] args, int defaultPort) {
    	for(String arg : args) {
    		if(arg != null && arg.contains(PORT_PREFIX)) {
    			try {
    				return Integer.parseInt( 
    						arg.replace(PORT_PREFIX,"").trim()
    						);
    			}catch(NumberFormatException e) {
    				logger.error(arg+" does not have a valid number");
    			}
    		}
    	}
    	return defaultPort;
    }
    
    /**
	 * Extracts interval number if provided in the format
	 *   --interval=3005
	 *   
	 * @param args - String arguments accepted from the cli
	 * @param defaultInterval default interval in the event that one was not specified
	 * */
    public static int getInterval(String[] args, int defaultInterval) {
    	for(String arg : args) {
    		if(arg != null && arg.contains(EMIT_INTERVAL_PREFIX)) {
    			try {
    				return Integer.parseInt( 
    						arg.replace(EMIT_INTERVAL_PREFIX,"").trim()
    						);
    			}catch(NumberFormatException e) {
    				logger.error(arg+" does not have a valid number");
    			}
    		}
    	}
    	return defaultInterval;
    }

    /**
	 * Extracts output format if provided in the format
	 *   --output-format
	 *   
	 * @param args - String arguments accepted from the cli
	 * @param defaultInterval default interval in the event that one was not specified
	 * */
	public static String getOutputFormat(String[] args, String defaultFormat) {
		for(String arg : args) {
    		if(arg != null && arg.contains(EMIT_OUTPUTFORMAT_PREFIX)) {
    			
    			String formatProvided = arg.replace(EMIT_OUTPUTFORMAT_PREFIX,"").trim().toLowerCase();
    			switch(formatProvided) {
    			case "text":
    			case "json":
    				return formatProvided;
    			default:
    				logger.error(arg+" does not use any of the available formats : text/json");
    			}
    			
    			
    		}
    	}
		return defaultFormat;
	}
}
