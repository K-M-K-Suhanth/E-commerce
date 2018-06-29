package com.niit.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.model.Product;
import com.niit.dao.ProductDAO;

public class ProductDAOTest {

	public static Product product;
	
	public static ProductDAO productDAO;
	
	@BeforeClass
	public static void preExecution() {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO =(ProductDAO)context.getBean("productDAO");
	}

	/*@Test
	public void addProductTest() {
		Product product=new Product();
		
		product.setCategoryId(147);
		product.setSupplierId(43);
		product.setPrice(3000);
		product.setProdDesc("this is used for cars");
		product.setProductName("microtec battery");
	
		assertTrue("problem in adding product",productDAO.addproduct(product));
	}*/
		@Test
		public void deleteProductTest() {
			Product product=productDAO.getproduct(35);
			
			assertTrue("problem in adding product",productDAO.deleteproduct(product));
		}
			
			/*@Test
			public void updateProductTest() {
								
				Product product=productDAO.getproduct(1);
				product.setProductName("exide");
			
				assertTrue("problem in adding product",productDAO.updateproduct(product));
	}*/
		
		@AfterClass
		public void postExecution()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.close();
		}
	
}
