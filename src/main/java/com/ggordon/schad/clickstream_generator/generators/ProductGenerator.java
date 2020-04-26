package com.ggordon.schad.clickstream_generator.generators;

import java.util.HashMap;
import java.util.Map;

import com.ggordon.schad.clickstream_generator.constants.ProductConstant;
import com.ggordon.schad.clickstream_generator.descriptor.ProductDataDescriptor;
import com.ggordon.schad.clickstream_generator.descriptor.IDataDescripter;

public class ProductGenerator extends Generator {
	
	protected IDataDescripter<Object, Integer> dataDescriptor;

	public ProductGenerator() {
		this(new ProductDataDescriptor());
	}

	public ProductGenerator(IDataDescripter<Object, Integer> dataDescriptor) {
		super();
		this.dataDescriptor = dataDescriptor;
	}

	public Map<String,Object> getRandomRecord() {
		int customerId = (int)(
				Math.random() * 
				dataDescriptor.getMaximumIdentifierValue()  + 
				dataDescriptor.getMinimumIdentifierValue()
		);
		

		Map<String,Object> record = new HashMap<String, Object>();
		record.put(ProductConstant.FIELD_PRODUCT_ID, customerId);
		
		return record;
	}

	

}
