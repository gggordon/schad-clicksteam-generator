/**
 * 
 */
package com.ggordon.schad.clickstream_generator.generators;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ggordon.schad.clickstream_generator.constants.ProductConstant;

/**
 * @author ggordon
 *
 */
public class ProductGeneratorTest {

	protected ProductGenerator instance;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		instance = new ProductGenerator();
	}


	/**
	 * Test method for {@link com.ggordon.schad.clickstream_generator.generators.ProductGenerator#getRandomRecord()}.
	 */
	@Test
	public void testGetRandomRecord() {
		Map<String,Object> record = instance.getRandomRecord();
		assertNotNull(record);
		assertTrue("Does not have field "+ProductConstant.FIELD_PRODUCT_ID,
				record.containsKey(ProductConstant.FIELD_PRODUCT_ID)
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
