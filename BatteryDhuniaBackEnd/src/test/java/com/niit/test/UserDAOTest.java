package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Category;
import com.niit.model.User;




public class UserDAOTest {

	private static User user;
	private static UserDAO userDAO; 
	

	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void preExecution()
	{
		context.scan("com.niit");
		context.refresh();
		userDAO =(UserDAO)context.getBean("userDAO");
	}
	
	/*@Test
	public void addUserTest()
	{
		User user=new User();
		user.setAddress("Chennai");
		user.setCustomername("moohi");
		user.setEmailid("mohith@gmail.com");
		user.setMobileno("4200");
		user.setPassword("mohini123");
		user.setRole("S");
		user.setUsername("mohit");
		
		assertTrue("problem in adding user",userDAO.adduser(user));
	}*/
	
	/*@Test
	public void deleteUserTest()
	{
		User user=new User();
		user.setAddress("banglore");
		user.setCustomername("sai");
		user.setEmailid("sai@gmail.com");
		user.setMobileno("38798");
		user.setPassword("sai23");
		user.setRole("A");
		user.setUsername("barath");
		
		assertTrue("problem in adding user",userDAO.deleteuser(user));
	}*/
	
	/*@Test
	public void updateUserTest()
	{
		User user=new User();
		user.setAddress("khammam");
		user.setCustomername("sus");
		user.setEmailid("sus@gmail.com");
		user.setMobileno("1010");
		user.setPassword("sus123");
		user.setRole("C");
		user.setUsername("sushanth");
		
		assertTrue("problem in adding user",userDAO.updateuser(user));
	}*/
	
	
	/*@Test
	public void getUserTest()
	{
		user = userDAO.getuser("barath");
		System.out.println(user);
		assertNotNull("get user test case", user);
	}*/
	
	/*@Test
	public void listUserTest()
	{
		userDAO.listusers();
	}*/
	
	
	@Test
	public void validateCredentialsSuccess()
	{
		User user = userDAO.validate("sushanth", "sus123");
		System.out.println(user);
		assertNotNull("validate test case",user);
	}
	
	@AfterClass
	public void postExecution()
	{
		context.close();
	}
}
