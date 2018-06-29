package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	private static final org.jboss.logging.Logger log = LoggerFactory.logger(UserDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;

	//@Autowired
	//Session session;
	@Transactional
	public boolean adduser(User user) {
		
		try {
			sessionFactory.getCurrentSession().save(user);
			//session.flush();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised:"+ e);
			return false;
		}
	}

	@Transactional
	public boolean updateuser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised:"+ e);
			return false;
		}
	}

	@Transactional
	public boolean deleteuser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised:"+ e);
			return false;
		}
	}

	@Transactional
	public User getuser(String username) {
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,username);
		System.out.println(user);
		session.close();
		return user;
	}

	@Transactional
	public User getrole(String role) {
		log.debug("getting user role");
		
		return sessionFactory.getCurrentSession().get(User.class, role);
	}
	
	@Transactional
	public User getpassword(String password) {
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,password);
		session.close();
		return user;
	}
	
	@Transactional
	public List<User> listusers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> listusers=query.list();
		session.close();
		return listusers;
	}

	public User validate(String username, String password) {
		Session session=sessionFactory.openSession();
			log.debug("Starting of the validate method");
			log.info(" user " + username + "trying to login");
		User user = (User)session.
			createCriteria(User.class).
			add(Restrictions.eq("username",username )).
			add(Restrictions.eq("password",password)).
			uniqueResult();
		session.close();
		return user;
		}

}
