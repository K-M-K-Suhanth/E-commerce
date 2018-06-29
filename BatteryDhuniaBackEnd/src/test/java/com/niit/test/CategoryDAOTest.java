package com.niit.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTest {

	public static CategoryDAO categoryDAO;
	public static Category category;
	
	@BeforeClass
	public static void preExecute()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	

	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		
		category.setCategoryName("industria use");
		category.setCateogryDesc("used heavy machines only");
		
		assertTrue("problem in adding category",categoryDAO.addcategory(category));
	}
	
	
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(1256);
		category.setCategoryName("solar");
		assertTrue("problem in updating",categoryDAO.updatecategory(category));
	}
	
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(33);
		assertTrue("problem in updating",categoryDAO.deletecategory(category));
	}
	
	@AfterClass
	public void postExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.close();
	}
}
