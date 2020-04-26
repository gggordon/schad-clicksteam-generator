package com.ggordon.schad.clickstream_generator.generators;

import java.util.Map;

public abstract class Generator implements IGenerator {
	
	public String getRandomRecord(String separator) {
		String line = "";
		Map<String,Object> record = getRandomRecord();
		int keysAdded =0;
		for(String key : record.keySet()) {
			line+=record.get(key)+
                 ( ++keysAdded != record.keySet().size() ? "|":"" ) ;
		}
		return line;
	}
}
