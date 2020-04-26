package com.ggordon.schad.clickstream_generator.descriptor;


public interface IDataDescripter<T,K> {
	
	K getMinimumIdentifierValue();
	K getMaximumIdentifierValue();
	
	K getMinimumValue(String fieldName);
	K getMaximumValue(String fieldName);

}
