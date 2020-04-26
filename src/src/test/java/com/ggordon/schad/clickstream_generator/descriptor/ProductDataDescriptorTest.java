package com.ggordon.schad.clickstream_generator.descriptor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductDataDescriptorTest {
	
	protected ProductDataDescriptor service;

	@Before
	public void setUp() throws Exception {
		service = new ProductDataDescriptor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMinimumIdentifierValue() {
		assertNotEquals(-1, service.getMinimumIdentifierValue(),0);
	}
	
	@Test
	public void testGetMaximumIdentifierValue() {
		assertNotEquals(-1, service.getMaximumIdentifierValue(),0);
		
	}
	


}
