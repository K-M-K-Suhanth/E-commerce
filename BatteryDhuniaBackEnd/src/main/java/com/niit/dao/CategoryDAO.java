package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDAO {

	public boolean addcategory(Category category);
	public boolean updatecategory(Category category);
	public boolean deletecategory(Category category);
	public Category getCategory(int categoryId);
	public List<Category> listCategories();
}
