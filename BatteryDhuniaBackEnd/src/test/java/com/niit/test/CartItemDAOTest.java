package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartItemDAO;
import com.niit.model.CartItem;

public class CartItemDAOTest {

	public static CartItemDAO CartItemDAO;
	public static CartItem cart;
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		CartItemDAO = (CartItemDAO)context.getBean("CartItemDAO");
	}
	
	@Test
	public void addCartTest()
	{
		CartItem cart=new CartItem();
		
		cart.setPrice(10700);
		cart.setProductId(122);
		cart.setProductname("invertor battery amaron");
		cart.setQuantity(2);
		cart.setStatus("NP");
		cart.setUsername("suhanth");
			
		assertTrue("problem in adding to cart",CartItemDAO.addToCart(cart));
	}
	
	/*@Test
	public void updateCartTest()
	{
		CartItem cart=CartItemDAO.getCartItem(34);
			cart.setProductname("updated name ");
		assertTrue("problem in adding to cart",CartItemDAO.updateCart(cart));
	}
	
	@Test
	public void deleteCartTest()
	{
		CartItem cart=CartItemDAO.getCartItem(111);
			
		assertTrue("problem in adding to cart",CartItemDAO.deleteFromCart(cart));
	}

	@Test
	public void getcartitem()
	{
		CartItemDAO.getCartItem(12);
	}*/
	
	@Test
	public void listcartitems()
	{
List<CartItem> list = CartItemDAO.listCartItems("suhanth");
		
		for(CartItem cart:list)
		{
			System.out.println("cartid: "+cart.getCartId()+"----");
			System.out.println("productid: "+cart.getProductId()+"----");
			System.out.println("product name: "+cart.getProductname()+"----");
			System.out.println("price: "+cart.getPrice()+"----");
			System.out.println("quantity: "+cart.getQuantity()+"---");
			System.out.println("useranem: "+cart.getUsername()+"---");
			System.out.println("status: "+cart.getStatus()+"---");
		}
		
		System.out.println("Cart Item Displayed");
	}
	
	@AfterClass
	public void postExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.close();
	}
}
