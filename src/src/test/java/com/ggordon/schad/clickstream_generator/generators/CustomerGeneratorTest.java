/**
 * 
 */
package com.ggordon.schad.clickstream_generator.generators;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ggordon.schad.clickstream_generator.constants.CustomerConstant;

/**
 * @author ggordon
 *
 */
public class CustomerGeneratorTest {

	protected CustomerGenerator instance;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		instance = new CustomerGenerator();
	}


	/**
	 * Test method for {@link com.ggordon.schad.clickstream_generator.generators.CustomerGenerator#getRandomRecord()}.
	 */
	@Test
	public void testGetRandomRecord() {
		Map<String,Object> record = instance.getRandomRecord();
		assertNotNull(record);
		assertTrue("Does not have field "+CustomerConstant.FIELD_CUSTOMER_ID,
				record.containsKey(CustomerConstant.FIELD_CUSTOMER_ID)
		);
		assertTrue("Does not have field "+CustomerConstant.FIELD_ZIP_CODE,
				record.containsKey(CustomerConstant.FIELD_ZIP_CODE)
		);
		
	}

	/**
	 * Test method for {@link com.ggordon.schad.clickstream_generator.generators.Generator#getRandomRecord(java.lang.String)}.
	 */
	@Test
	public void testGetRandomRecordString() {
		String line = instance.getRandomRecord("|");
		assertNotNull(line);
		assertTrue(line.length()>1);
	}

}
