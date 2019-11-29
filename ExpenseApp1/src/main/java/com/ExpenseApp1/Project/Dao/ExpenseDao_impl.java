package com.ExpenseApp1.Project.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.ExpenseApp1.Project.pojo.Expense;
@Repository
@Transactional
public class ExpenseDao_impl implements IExpenseDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Expense getExpenseById(Integer id) {
		String jpql="Select e from Expense e where e.expense_id=:eid";
		Expense expense=entityManager.createQuery(jpql,Expense.class).setParameter("eid", id).getSingleResult();
		return expense;
	}
	@Override
	public List<Object> getMonthlyExpense() 
	{
		String jpql="select e.expense_amount from Expense e ";
		return entityManager.createQuery(jpql,Object.class).getResultList();
	
	}
	@Override
	public List<Object> getUsersMonthlyExpense(Integer id)
	{
					String jpql="select  e.expense_type from Expense e where userid=:cid";
					
						return entityManager.createQuery(jpql,Object.class).setParameter("cid",id).getResultList();

	}
}
