package com.ggordon.schad.clickstream_generator.generators;

import java.util.HashMap;
import java.util.Map;

import com.ggordon.schad.clickstream_generator.constants.CustomerConstant;
import com.ggordon.schad.clickstream_generator.descriptor.CustomerDataDescriptor;
import com.ggordon.schad.clickstream_generator.descriptor.IDataDescripter;

public class CustomerGenerator  implements IGenerator {
	
	protected IDataDescripter<Object, Integer> dataDescriptor;

	public CustomerGenerator() {
		this(new CustomerDataDescriptor());
	}

	public CustomerGenerator(IDataDescripter<Object, Integer> dataDescriptor) {
		super();
		this.dataDescriptor = dataDescriptor;
	}

	public Map<String,Object> getRandomRecord() {
		int customerId = (int)(
				Math.random() * 
				dataDescriptor.getMaximumIdentifierValue()  + 
				dataDescriptor.getMinimumIdentifierValue()
		);
		int zipCode = (int)(
				Math.random() * 
				dataDescriptor.getMaximumValue(
						CustomerConstant.FIELD_ZIP_CODE
				)+ 
				dataDescriptor.getMinimumValue(
						CustomerConstant.FIELD_ZIP_CODE
				)
		);

		Map<String,Object> record = new HashMap<String, Object>();
		record.put(CustomerConstant.FIELD_CUSTOMER_ID, customerId);
		record.put(CustomerConstant.FIELD_ZIP_CODE, zipCode);
		return record;
	}

	

}
