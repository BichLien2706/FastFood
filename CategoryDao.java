package com.thanhhc.dao;

import java.util.List;

import com.thanhhc.model.Category;

public interface CategoryDao {
	void insert(Category category);

	void edit(Category category);

	void delete(int id);

	Category get(int id);
	
	Category get(String name);
	
	List<Category> getAll();

	List<Category> search(String username);
}
