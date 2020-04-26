package com.ggordon.schad.clickstream_generator.descriptor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ggordon.schad.clickstream_generator.constants.ProductConstant;

/**
 * Descriptor for customer table in popular retail_db dataset
 * */
public class ProductDataDescriptor implements IDataDescripter<Object, Integer>{

	private static Logger logger = LogManager.getLogger(ProductDataDescriptor.class);
	
	private static String filePath = "data/products/part-00000";
	private static int minimumId  = Integer.MAX_VALUE,
			           maximumId  = Integer.MIN_VALUE;
	
	
	
	static {
		try {
			String resourceFilePath = ProductDataDescriptor
					   .class
					   .getClassLoader()
					   .getResource(filePath)
					   .getFile();
			if(!new File(resourceFilePath).exists()) {
				logger.debug("Resource file - "+resourceFilePath+" does not exist");
				initializeDefaultValues();
			}else {
				BufferedReader in = new BufferedReader(
						new FileReader(
								ProductDataDescriptor
								   .class
								   .getClassLoader()
								   .getResource(filePath)
								   .getFile()
								)
						);
				while(in.ready()) {
	                String[] record = in.readLine().split(",");
	                
	                try {
	                    int productId = Integer.parseInt(record[0]);
	                    
	                    if(productId>maximumId)maximumId = productId;
	                    if(productId < minimumId)minimumId = productId;
	                    
	                }catch(NumberFormatException e) {
	                	continue;
	                }
	                
	                
				}
				in.close();
			}
			
		}catch(IOException e) {
			logger.error("Unable to initialize customer details from file",e);
			initializeDefaultValues();
			
		}
	}
	private static void initializeDefaultValues() {
		logger.debug("Initializing using default values");
		minimumId = 1;
		maximumId=1344;
	}
	
	public Integer getMinimumIdentifierValue() {
		return minimumId;
	}

	public Integer getMaximumIdentifierValue() {
		return maximumId;
	}

	public Map<String,Object> getRandomRecord() {
		int productId = (int)(Math.random() * maximumId  + minimumId);
		

		Map<String,Object> record = new HashMap<String, Object>();
		record.put(ProductConstant.FIELD_PRODUCT_ID, productId);
		
		return record;
	}

	public Integer getMinimumValue(String fieldName) {
		if(fieldName != null) {
			if(fieldName.equals(ProductConstant.FIELD_PRODUCT_ID)) {
				return minimumId;
			}
			
		}
		return null;
	}

	public Integer getMaximumValue(String fieldName) {
		if(fieldName != null) {
			if(fieldName.equals(ProductConstant.FIELD_PRODUCT_ID)) {
				return maximumId;
			}
			
		}
		return null;
	}

}
