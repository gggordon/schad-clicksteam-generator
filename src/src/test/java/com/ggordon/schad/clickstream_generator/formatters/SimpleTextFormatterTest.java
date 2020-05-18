package com.ggordon.schad.clickstream_generator.formatters;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;


public class SimpleTextFormatterTest {
	protected JSONFormatter instance;

	@Test
	public void testFormat() {
		instance = new JSONFormatter();
		HashMap<String,Object> record = new HashMap<String,Object>();
		record.put("a",1);
		record.put("b","c");
		String expected = "{\"a\":1,\"b\":\"c\"}";
		assertEquals(expected,instance.format(record));
	}
	

}
