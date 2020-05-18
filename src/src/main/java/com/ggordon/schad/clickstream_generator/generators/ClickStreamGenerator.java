package com.ggordon.schad.clickstream_generator.generators;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.ggordon.schad.clickstream_generator.constants.ClickStreamConstant;

public class ClickStreamGenerator implements IGenerator {
	
	protected IGenerator customerGenerator;
	protected IGenerator productGenerator;
	protected DateFormat dateFormat ;
	
	public ClickStreamGenerator() {
		customerGenerator = new CustomerGenerator();
		productGenerator = new ProductGenerator();
		dateFormat =  new SimpleDateFormat(ClickStreamConstant.FORMAT_DATE);
	}
	
	

	public ClickStreamGenerator(IGenerator customerGenerator, IGenerator productGenerator,String dateFormat) {
		super();
		this.customerGenerator = customerGenerator;
		this.productGenerator = productGenerator;
		this.dateFormat = new SimpleDateFormat(dateFormat);
	}



	public Map<String, Object> getRandomRecord() {
		Map<String,Object> customer = customerGenerator.getRandomRecord(),
				           product = productGenerator.getRandomRecord();
		Map<String,Object> record = new HashMap<String, Object>();
		record.putAll(customer);
		record.putAll(product);
		record.put(ClickStreamConstant.FIELD_BROWSER_X_POSITION,randomNumberBetween(0, 1366));
		record.put(ClickStreamConstant.FIELD_BROWSER_Y_POSITION,randomNumberBetween(0, 2000));
		record.put(ClickStreamConstant.FIELD_DATE_TIME,currentTimeStamp());
		
		return record;
	}
	
	protected float randomNumberBetween(float min,float max) {
		return (float)(Math.random()*max+min);
	}
	
	protected String currentTimeStamp() {

		return dateFormat.format(new java.util.Date());
	}

	

}
