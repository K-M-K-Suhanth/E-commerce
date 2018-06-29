package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Product;
import com.niit.model.User;

@Repository(value="productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addproduct(Product product) {
		try {
			
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised: " + e);
			e.printStackTrace();
			return false;
		}
		}

	@Transactional
	public boolean updateproduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception arised:"+ e);
		return false;
	}
	}

	@Transactional
		public boolean deleteproduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised:"+ e);
			return false;
		}
	}


	@Transactional
		public Product getproduct(int productId) {
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		session.close();
		return product;
	}

	@Transactional
		public List<Product> listproducts() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from  Product");
	   List<Product> listproducts=query.list();
		System.out.println(listproducts);
		session.close();
		return listproducts;
	}

}
