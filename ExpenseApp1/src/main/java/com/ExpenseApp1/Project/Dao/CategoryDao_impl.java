 package com.ExpenseApp1.Project.Dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ExpenseApp1.Project.Repository.CategoryRepository;



@Repository
@Transactional
public class CategoryDao_impl implements ICategoryDao
{
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	CategoryRepository categoryRepository;
	

}
