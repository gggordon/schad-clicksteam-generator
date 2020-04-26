package com.ggordon.schad.clickstream_generator.descriptor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerDataDescriptorTest {
	
	protected CustomerDataDescriptor instance;

	@Before
	public void setUp() throws Exception {
		instance = new CustomerDataDescriptor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMinimumIdentifierValue() {
		assertNotEquals(-1, instance.getMinimumIdentifierValue(),0);
	}
	
	@Test
	public void testGetMaximumIdentifierValue() {
		assertNotEquals(-1, instance.getMaximumIdentifierValue(),0);
	}
	
	

}
