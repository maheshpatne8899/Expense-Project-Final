package com.ExpenseApp1.Project.Controller;


import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseApp1.Project.Dto.CategoryDto;
import com.ExpenseApp1.Project.Exception.CategoryNotFoundException;
import com.ExpenseApp1.Project.Repository.CategoryRepository;
import com.ExpenseApp1.Project.Service.ICategoryService;
import com.ExpenseApp1.Project.pojo.Category;


@RestController
@RequestMapping("/category")
public class CategoryController

{	
	@Autowired
	ICategoryService categoryService;
	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * Method used to add Category 
	 * @param Category Object
	 * @return status string
	 */
	@PostMapping("/addcategory")
	public Category addCategory(@RequestBody CategoryDto categorydto)
	{
		Category cat=new Category();
		cat.setCategoryId(categorydto.getCategoryId());
		cat.setCategoryName(categorydto.getCategoryName());
		cat.setCategoryDesc(categorydto.getCategoryDesc());
		return categoryRepository.save(cat);
	}
	
	/**
	 * Method used get specific Category 
	 * @param Integer id
	 * @return Category Details if id is valid or returns and Exception
	 */	
	@GetMapping("/categorylist/{id}")
	public Optional<Category> getCategoryById(@PathVariable Integer id)
	{
		try
		{
		Optional<Category> categoryData=categoryService.getCategoryById(id);
		if(categoryData==null)
		{
			throw new CategoryNotFoundException("Category Not In Stock");
		}
		return categoryData;
		}
		
		catch (Exception e) 
		{
			throw new CategoryNotFoundException("Category Not Found");
		}
	}
	

	/**
	 * Method used to update Category 
	 * @param Integer id
	 * @return Updated Category Details (Category Object)
	 */
    @PutMapping("/category/{id}")	
	ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category)	{
		Category result=categoryRepository.save(category);
	return ResponseEntity.ok().body(result);
		}
	
    
    /**
	 * Method used to get Category List 
	 * @param No parameter
	 * @return Category List 
	 */	
	@GetMapping("/categories")	
 public ResponseEntity<List<Category>>categories()
	 {
		
		return ResponseEntity.ok().body(categoryRepository.findAll());
	 
      }
	 
    /**
	 * Method used to Delete Category  
	 * @param Integer idNo parameter
	 * @return Null
	 */	
    @DeleteMapping("/category/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Integer id)
   {
	     categoryRepository.deleteById(id);
	     return ResponseEntity.ok().build();
    }
}