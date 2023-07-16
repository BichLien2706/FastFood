package com.thanhhc.service.impl;

import java.io.File;
import java.util.List;

import com.thanhhc.dao.CategoryDao;
import com.thanhhc.dao.impl.CategoryDaoImpl;
import com.thanhhc.model.Category;
import com.thanhhc.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void insert(Category category) {
		categoryDao.insert(category);

	}

	@Override
	public void edit(Category newCategory) {
		Category oldCate = categoryDao.get(newCategory.getId());
		oldCate.setName(newCategory.getName());
		categoryDao.edit(oldCate);

	}
	
//	@Override
//	public void edit(Category newCategory) {
//		Category oldCate = categoryDao.get(newCategory.getId());
//		
//		oldCate.setName(newCategory.getName());
//		if (newCategory.getImage() != null) {
//			// XOA ANH CU DI
//			String fileName = oldCate.getImage();
//			final String dir = "F:\\upload";
//			File file = new File(dir + "/" + fileName);
//			if (file.exists()) {
//				file.delete();
//			}
//
//			oldCate.setImage(newCategory.getImage());
//		}
//
//		categoryDao.edit(oldCate);
//
//	}  

	@Override
	public void delete(int id) {
		categoryDao.delete(id);

	}

	@Override
	public Category get(int id) {
		return categoryDao.get(id);
	}

	@Override
	public Category get(String name) {
		return categoryDao.get(name);
	}
	
	@Override
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	@Override
	public List<Category> search(String username) {
		return categoryDao.search(username);
	}
}