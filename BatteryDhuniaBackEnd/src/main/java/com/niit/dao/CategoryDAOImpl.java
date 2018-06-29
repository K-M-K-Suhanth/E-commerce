package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
		public boolean addcategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised: " + e);
			return false;
		}
	}

	@Transactional
		public boolean updatecategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised" + e);
			return false;
		}
	}

	@Transactional
	public boolean deletecategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised" + e);
			return false;
		}
	}

	@Transactional
		public Category getCategory(int categoryId) {
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,categoryId);
		session.close();
		return category;
	}

	@Transactional
		public List<Category> listCategories() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from  Category");
		List<Category> listCategories=query.list();
		session.close();
		return listCategories;
	}

}
