package com.niit.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartItemDAO;
import com.niit.dao.UserDAO;
import com.niit.model.CartItem;
import com.niit.model.User;

@Controller
public class HomeController {
	
	@Autowired
	UserDAO userDAO;
		
	@Autowired
	CartItemDAO cartItemDAO;
	
	@Autowired
	HttpSession httpSession;
	

	
	@RequestMapping(value="/wishlist")
	public String registerpage()
	{
		return "wishlist";
	}
	
	@RequestMapping(value="/")
	public String indexpage(Model model)
	{
		model.addAttribute("user", new User());
		return "index";
	}
	
	@RequestMapping(value="/aboutus")
	public String aboutpage()
	{
		return "aboutus";
	}
	
	@RequestMapping(value="/contactus")
	public String contatcuspage()
	{
		return "contactus";
	}
	
	@PostMapping(value="/validate")
	public String userhomepage(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		ModelAndView mv = new ModelAndView("userhome");
		
		
		User user= userDAO.validate(username, password);
		String logedin=username;
		System.out.println("home: "+logedin);
		
		if (user==null)
		{
			mv.addObject("errorMessage", "Invalid credentials, pls try agin.");
			return "index";
			
		}
		else
		{
			httpSession.setAttribute("user", user);
			httpSession.setAttribute("loggedInUserID", user.getUsername());
			String posi = user.getRole();
			List<CartItem> carts = cartItemDAO.listCartItems(user.getUsername());
			httpSession.setAttribute("size", carts.size());
			
			
			httpSession.setAttribute("carts", carts);

						
			if(posi.equals("A"))
			{
				System.out.println("admin");
				httpSession.setAttribute("isAdmin", true);
				return "adminhome";
			}
			else
			{
				System.out.println("customer");
				httpSession.setAttribute("is customer", true);
				return "userhome";
			}
		}
		
	}
	
	@RequestMapping(value="/newuser",method= RequestMethod.POST)
	public String newuserhomepage(@ModelAttribute("user") User user)	{
		
		userDAO.adduser(user);
		return "redirect:/";
	}

}
