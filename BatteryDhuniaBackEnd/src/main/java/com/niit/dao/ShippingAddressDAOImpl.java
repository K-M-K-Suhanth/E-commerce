package com.niit.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.ShippingAddress;

@Repository("addressDAO")
@Transactional
public class ShippingAddressDAOImpl implements ShippingAddressDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addAddress(ShippingAddress address) {
		try {
		sessionFactory.getCurrentSession().save(address);
		return true;
		}
			catch(Exception e)
			{
			return false;
		}
		
	}

	
}
