package com.ExpenseApp1.Project.Service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ExpenseApp1.Project.Dao.ICategoryDao;
import com.ExpenseApp1.Project.Repository.CategoryRepository;
import com.ExpenseApp1.Project.pojo.Category;

@Service
public class CategoryServiceImpl implements ICategoryService
{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	ICategoryDao categoryDao;
	
	public Optional<Category> getCategoryById(int cid)
	{
		Optional<Category> categoryData=categoryRepository.findByCategoryId(cid);
		
		return categoryData;
	}
	
	

}
