package com.ExpenseApp1.Project.Dao;

import java.util.List;

import com.ExpenseApp1.Project.pojo.Expense;

public interface IExpenseDao {
	

	Expense getExpenseById(Integer id);

	List<Object> getMonthlyExpense();

	List<Object> getUsersMonthlyExpense(Integer id);

}
