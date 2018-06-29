package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.ShippingAddressDAO;
import com.niit.model.ShippingAddress;
import com.niit.model.User;

@Controller
public class PaymentController {
	
	@Autowired
	ShippingAddressDAO addressDAO;

	@RequestMapping(value="/orderconfirm")
	public String payment()
	{
		return "payment";
	}
	
	@RequestMapping(value="/address")
	public String address()
	{
		return "address";
	}
	
	@RequestMapping(value="/addaddress",method= RequestMethod.POST)
	public String newuserhomepage(@RequestParam("flat") int flat,@RequestParam("street") String street,@RequestParam("area") String area,@RequestParam("city") String city,@RequestParam("state") String state,@RequestParam("zipcode") int zipcode )
	{
		ShippingAddress shippingAddress=new ShippingAddress();
		
		shippingAddress.setArea(area);
		shippingAddress.setCity(city);
		shippingAddress.setDoorno(flat);
		shippingAddress.setState(state);
		shippingAddress.setStreet(street);
		shippingAddress.setZipcode(zipcode);
				
		addressDAO.addAddress(shippingAddress);
		return "thankyou";
	}
	
	@RequestMapping(value="/receipt")
	public String receipt()
	{
		return "receipt";
	}
	
	@RequestMapping(value="/thankyou")
	public String thankq()
	{
		return "thankyou";
	}
}
