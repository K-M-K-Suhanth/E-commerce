package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ShippingAddressDAO;
import com.niit.model.ShippingAddress;

public class ShippingAddressDAOTest {

	public static ShippingAddress shippingAddress;
	
	public static ShippingAddressDAO addressDAO;
	
	@BeforeClass
	public static void preExecution() {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		addressDAO =(ShippingAddressDAO)context.getBean("addressDAO");
	}
	
	@Test
	public void addAddressTest()
	{
		ShippingAddress shippingAddress = new ShippingAddress();
		shippingAddress.setArea("annanager");
		shippingAddress.setCity("chenai");
		shippingAddress.setDoorno(170);
		shippingAddress.setState("TN");
		shippingAddress.setStreet("al-block");
		shippingAddress.setZipcode(600040);
		
		assertTrue("problem in adding address",addressDAO.addAddress(shippingAddress));
	}
	
	@AfterClass
	public void postExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.close();
	}
}
