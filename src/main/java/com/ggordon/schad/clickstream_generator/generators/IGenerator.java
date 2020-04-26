package com.ggordon.schad.clickstream_generator.generators;

import java.util.Map;

public interface IGenerator {
	Map<String,Object> getRandomRecord();
	String getRandomRecord(String separator);
}
