package com.ExpenseApp1.Project.Service;

import java.util.Optional;

import com.ExpenseApp1.Project.pojo.Category;

public interface ICategoryService {
	
	public Optional<Category> getCategoryById(int cid);
	
	

}
