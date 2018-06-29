package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO {

	public boolean addproduct(Product product);
	public boolean updateproduct(Product product);
	public boolean deleteproduct(Product product);
	public Product getproduct(int productId);
	public List<Product> listproducts();
}
