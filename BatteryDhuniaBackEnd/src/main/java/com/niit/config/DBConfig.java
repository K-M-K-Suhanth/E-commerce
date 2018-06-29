package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.OrderDetail;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;
import com.niit.model.User;
import com.niit.dao.CartItemDAO;
import com.niit.dao.CartItemDAOImpl;
import com.niit.dao.CategoryDAO;
import com.niit.dao.CategoryDAOImpl;
import com.niit.dao.OrderDAO;
import com.niit.dao.OrderDAOImpl;
import com.niit.dao.ProductDAO;
import com.niit.dao.ProductDAOImpl;
import com.niit.dao.ShippingAddressDAO;
import com.niit.dao.ShippingAddressDAOImpl;
import com.niit.dao.UserDAO;
import com.niit.dao.UserDAOImpl;

@Configuration
@ComponentScan(basePackages="com.niit.*")
@EnableTransactionManagement
public class DBConfig {

	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/jdbc");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		System.out.println("DataSource Created");
	    return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProperties=new Properties();
		
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
		hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		factoryBuilder.addAnnotatedClass(User.class);
		factoryBuilder.addAnnotatedClass(Product.class);
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(CartItem.class);
		factoryBuilder.addAnnotatedClass(OrderDetail.class);
		factoryBuilder.addAnnotatedClass(ShippingAddress.class);
		factoryBuilder.addProperties(hibernateProperties);
		System.out.println("Session Factory Created");
		return factoryBuilder.buildSessionFactory();
	}
	
	@Bean(name="userDAO")
	public UserDAO getuserDAO()
	{
		System.out.println("UserDAO called");
		return new UserDAOImpl();
	}
	
	@Bean(name="productDAO")
	public ProductDAO getproductDAO()
	{
		System.out.println("ProductDAO called");
		return new ProductDAOImpl();
	}
	
	@Bean(name="categoryDAO")
	public CategoryDAO getcategoryDAO()
	{
		System.out.println("CategoryDAO called");
		return new CategoryDAOImpl();
	}
	
	@Bean(name="cartItemDAO")
	public CartItemDAO getcartItemDAO()
	{
		System.out.println("CartItemDAO called");
		return new CartItemDAOImpl();
	}
	
	@Bean(name="orderDAO")
	public OrderDAO getorderDAO()
	{
		System.out.println("OrderDAO called");
		return new OrderDAOImpl();
	}
	
	@Bean(name="addressDAO")
	public ShippingAddressDAO getaddressDAO()
	{
		System.out.println("AddressDAO called");
		return new ShippingAddressDAOImpl();
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		
		System.out.println("Transaction Created");
		return new HibernateTransactionManager(sessionFactory);
	}
}
