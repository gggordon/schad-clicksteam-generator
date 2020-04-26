package com.ggordon.schad.clickstream_generator.cli;

/**
 * Helper class to extract Cli Arguments
 * */
public class CliArgumentParser {
	public static String PORT_PREFIX="--port=";
	public static String EMIT_INTERVAL_PREFIX="--interval=";
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
    				//we will ignore this exception
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
    				//we will ignore this exception
    			}
    		}
    	}
    	return defaultInterval;
    }
}
