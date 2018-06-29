package com.niit.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartItemDAO;
import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Category;
import com.niit.model.Product;

@Controller
public class ProductController {

	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private UserDAO userDAO;
	
		@RequestMapping(value="/insertproduct", method = RequestMethod.GET)
	    public ModelAndView visitadminpage1(Model model) {
			
			List<Product> listProducts = productDAO.listproducts();
			model.addAttribute("listProducts", listProducts);
	
			return new ModelAndView("insertproduct");
	    }
			
		/*@RequestMapping(value="/InsertProduct", method = RequestMethod.POST)
		public String addProduct(@ModelAttribute("product") Product product,@RequestParam("pimage") MultipartFile productImage,Model m)
		{
			productDAO.addproduct(product);
			
			Product product1=new Product(); 
			m.addAttribute(product1); 
			
			
			
			String path="C:\\Users\\suhanth\\eclipse-workspace\\BatteryDhuniaFrontEnd\\src\\main\\webapp\\resources\\images";
			path=path+String.valueOf(product.getProductId())+".jpg";
			File filepath=new File(path);
			
			if(!productImage.isEmpty())
			{
				try
				{
					byte[] buffer=productImage.getBytes();
					FileOutputStream fos=new FileOutputStream(filepath);
					BufferedOutputStream bs=new BufferedOutputStream(fos);
					bs.write(buffer);
					bs.close();
				}
				catch(Exception e)
				{
					m.addAttribute("errorInfo", "There is Exception:"+e.getMessage());
				}
			}
			else
			{
				m.addAttribute("errorInfo", "There is System Problem");
			}
			
			
			
			return "product";
		}
		
		public LinkedHashMap<Integer,String> getCategories()
		{
			List<Category> listCategories=categoryDAO.listCategories();
			
			LinkedHashMap<Integer,String> categoryList=new LinkedHashMap<Integer,String>();
			
			for(Category category:listCategories)
			{
				categoryList.put(category.getCategoryId(), category.getCategoryName());
			}
			
			return categoryList;
		}*/
		
		@RequestMapping(value="/conforminsertproduct", method = RequestMethod.GET)
		public String addProducts(@RequestParam("proname") String proname, @RequestParam("prodesc") String prodesc,  @RequestParam("procost") int procost,@RequestParam("supid") int supid,@RequestParam("catid") int catid,ModelMap model) {
		Product product=new Product();
		product.setProductName(proname);
		product.setProdDesc(prodesc);
		product.setPrice(procost);
		product.setSupplierId(supid);
		product.setCategoryId(catid);
			
		productDAO.addproduct(product);
		return "insertproduct";			
	    }
		
		@RequestMapping(value="/updateProduct/{productId}",method=RequestMethod.GET)
		public String updateProduct(@PathVariable("productId") int productId,Model m)
		{
			Product product=productDAO.getproduct(productId);		
			List<Product> listProducts=productDAO.listproducts();
			System.out.println("in product controller-------------");
			System.out.println(product.getProductName());
			System.out.println(listProducts.get(0).getProdDesc());
			m.addAttribute("listProducts",listProducts);
			m.addAttribute("productInfo",product);
			return "UpdateProduct";
		}
		
		@RequestMapping(value="/UpdateProduct",method=RequestMethod.GET)
		public String updateProductInDB(@RequestParam("productId") int productId,@RequestParam("proname") String proname,@RequestParam("prodesc") String prodesc,@RequestParam("procost") int procost,@RequestParam("catid") int catid,Model m)
		{
			Product product=productDAO.getproduct(productId);
			product.setProductName(proname);
			product.setProdDesc(prodesc);
			product.setPrice(procost);
					
			productDAO.updateproduct(product);
			List<Product> listProducts=productDAO.listproducts();
			m.addAttribute("listProducts",listProducts);
			return "insertproduct";
		}
	
		@RequestMapping(value="/deleteProduct/{productId}")
		public String deleteProduct(@PathVariable("productId") int productId,Model m)
		{	Product product=productDAO.getproduct(productId);		
			productDAO.deleteproduct(product);		
			List<Product> listProducts=productDAO.listproducts();
			m.addAttribute("listProducts",listProducts);
			return "insertproduct";
		}
		
		@RequestMapping("/displayproducts")
		public String selectByCategory(Model model) {
			List<Product> listProducts = productDAO.listproducts();
			model.addAttribute("listProducts", listProducts);
		return "displayproducts";
		}

		@RequestMapping(value="/displayproducts/{productId}")
		public String proddesc(@PathVariable("productId") int productId,Model m)
		{
			Product product=productDAO.getproduct(productId);
			m.addAttribute("product", product);
			return "productdescription";
		}
	
}
