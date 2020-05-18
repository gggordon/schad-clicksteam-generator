package com.ggordon.schad.clickstream_generator.formatters;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;


public class JSONFormatterTest {
	protected SimpleTextFormatter instance;

	@Test
	public void testFormat() {
		instance = new SimpleTextFormatter("||");
		HashMap<String,Object> record = new HashMap<String,Object>();
		record.put("a",1);
		record.put("b","c");
		String expected = "1||c";
		assertEquals(expected,instance.format(record));
	}
	

}
