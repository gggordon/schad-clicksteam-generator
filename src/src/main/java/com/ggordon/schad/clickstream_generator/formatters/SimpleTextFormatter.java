package com.ggordon.schad.clickstream_generator.formatters;

import java.util.Map;

public class SimpleTextFormatter implements IFormatter{
	
	protected String separator;
	
	public SimpleTextFormatter() {
		this("|");
	}
	
	public SimpleTextFormatter(String separator) {
		this.separator = separator;
	}

	@Override
	public String format(Map<String, Object> record, Map<String, Object> options) {
		String line = "";
		int keysAdded =0;
		for(String key : record.keySet()) {
			line+=record.get(key)+
                 ( ++keysAdded != record.keySet().size() ? separator:"" ) ;
		}
		return line;
	}

	@Override
	public String format(Map<String, Object> record) {
		return format(record,null);
	}


}
