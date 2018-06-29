package com.niit.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.ProductDAO;
import com.niit.model.CartItem;
import com.niit.model.Product;
import com.niit.dao.CartItemDAO;

@Controller
public class CartController {

	@Autowired
	CartItemDAO CartItemDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	HttpSession httpSession;
	
		
	@RequestMapping(value="/showcart", method = RequestMethod.GET)
    public ModelAndView visitadminpage1(Model model) {
		
		String logedin = (String) httpSession.getAttribute("loggedInUserID");
				
		List<CartItem> listCartItems = CartItemDAO.listCartItems(logedin);
		model.addAttribute("listCartItems", listCartItems);
        model.addAttribute("totalCost",this.calculateTotalCost(listCartItems));
		return new ModelAndView("cart");
    }

	@RequestMapping(value="/addtocart/{productId}")
	public String addToCart(@PathVariable("productId") int productId,@RequestParam("quantity")int quantity,HttpSession session,Model m)
	{
		
		CartItem cartItem=new CartItem();
		Product product=productDAO.getproduct(productId);
		String username=(String)session.getAttribute("loggedInUserID");
		
		cartItem.setUsername(username);
		cartItem.setProductId(productId);
		cartItem.setQuantity(quantity);
		cartItem.setProductname(product.getProductName());
		cartItem.setPrice(product.getPrice());
		cartItem.setStatus("NP");
		
		CartItemDAO.addToCart(cartItem);
		
		List<CartItem> listCartItems=CartItemDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		session.setAttribute("CartItems",listCartItems.size());
		
		return "redirect:/displayproducts";
	}
	
	@RequestMapping(value="/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m,HttpSession session)
	{
		
		CartItem cartItem=CartItemDAO.getCartItem(cartItemId);
		CartItemDAO.deleteFromCart(cartItem);
		
		String username=(String)session.getAttribute("loggedInUserID");
		List<CartItem> listCartItems=CartItemDAO.listCartItems(username);
		
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("totalCost", this.calculateTotalCost(listCartItems));
		session.setAttribute("CartItems",listCartItems.size());
		
		return "cart";
	}
	
	public int calculateTotalCost(List<CartItem> cartItems) {
		
		int totalCost=0;
		int count=0;
		while(count<cartItems.size()) {
			totalCost=totalCost+(cartItems.get(count).getPrice()*cartItems.get(count).getQuantity());
			count++;
		}
		return totalCost;
	}
}
