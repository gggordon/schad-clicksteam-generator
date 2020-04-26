package com.ggordon.schad.clickstream_generator.descriptor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ggordon.schad.clickstream_generator.constants.CustomerConstant;

/**
 * Descriptor for customer table in popular retail_db dataset
 * */
public class CustomerDataDescriptor implements IDataDescripter<Object, Integer>{

	private static Logger logger = LogManager.getLogger(CustomerDataDescriptor.class);
	
	private static String filePath = "data/customers/part-00000";
	private static int minimumId  = Integer.MAX_VALUE,
			           maximumId  = Integer.MIN_VALUE,
			           minZipCode = Integer.MAX_VALUE,
			           maxZipCode = Integer.MIN_VALUE;
	
	
	
	static {
		try {
			BufferedReader in = new BufferedReader(
					new FileReader(
							CustomerDataDescriptor
							   .class
							   .getClassLoader()
							   .getResource(filePath)
							   .getFile()
							)
					);
			while(in.ready()) {
                String[] record = in.readLine().split(",");
                
                try {
                    int customerId = Integer.parseInt(record[0]),
                        zipCode = Integer.parseInt( record[record.length-1]);
                    
                    if(customerId>maximumId)maximumId = customerId;
                    if(customerId < minimumId)minimumId = customerId;
                    if(zipCode > maxZipCode)maxZipCode = zipCode;
                    if(zipCode < minZipCode)minZipCode = zipCode;
                }catch(NumberFormatException e) {
                	continue;
                }
                
                
			}
			in.close();
		}catch(IOException e) {
			logger.error("Unable to initialize customer details from file",e);
			minimumId = 1;
			maximumId=12344;
			minZipCode=603;
			maxZipCode=99204;
		}
	}
	public Integer getMinimumIdentifierValue() {
		return minimumId;
	}

	public Integer getMaximumIdentifierValue() {
		return maximumId;
	}

	public Integer getMinimumValue(String fieldName) {
		if(fieldName != null) {
			if(fieldName.equals(CustomerConstant.FIELD_CUSTOMER_ID)) {
				return minimumId;
			}
			if(fieldName.equals(CustomerConstant.FIELD_ZIP_CODE)) {
				return minZipCode;
			}
		}
		return null;
	}

	public Integer getMaximumValue(String fieldName) {
		if(fieldName != null) {
			if(fieldName.equals(CustomerConstant.FIELD_CUSTOMER_ID)) {
				return maximumId;
			}
			if(fieldName.equals(CustomerConstant.FIELD_ZIP_CODE)) {
				return maxZipCode;
			}
		}
		return null;
	}

	

}
