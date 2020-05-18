package com.ggordon.schad.clickstream_generator.formatters;

import java.util.Map;

/**
 * Formats record
 * */
public interface IFormatter {
	/**
	 * Provides a record in a particular format
	 * 
	 * @param record - map of key/value pairs to be formatted
	 * @param options - optional map of key/value options for formatter
	 * @return formatted record
	 * */
	String format(Map<String,Object> record, Map<String,Object> options);
	
	/**
	 * Provides a record in a particular format
	 * 
	 * @param record - map of key/value pairs to be formatted
	 * @return formatted record
	 * */
	String format(Map<String,Object> record);

}
