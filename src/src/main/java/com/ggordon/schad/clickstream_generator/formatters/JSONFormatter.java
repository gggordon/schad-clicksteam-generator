package com.ggordon.schad.clickstream_generator.formatters;


import java.util.Map;

public class JSONFormatter implements IFormatter {
	
    protected String jsonifyValue(Object value) {
    	if(value instanceof Number) {
    		return value.toString();
    	}else {
    		return "\""+value+"\"";
    	}
    }

	@Override
	public String format(Map<String, Object> record, Map<String, Object> options) {
		String line="{";
		int keysAdded =0;
		for(String key : record.keySet()) {
			line+="\""+key+"\":"+jsonifyValue(record.get(key))+
                 ( ++keysAdded != record.keySet().size() ? ",":"}" ) ;
		}
		return line;
	}

	@Override
	public String format(Map<String, Object> record) {
		return format(record,null);
	}

}
