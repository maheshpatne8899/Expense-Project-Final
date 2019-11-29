package com.ExpenseApp1.Project.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ExpenseApp1.Project.Dao.IExpenseDao;
import com.ExpenseApp1.Project.Repository.ExpenseRepository;
import com.ExpenseApp1.Project.pojo.Expense;

@Service
public class ExpenseServiceImpl implements IExpenseService
{
	@Autowired
	IExpenseDao expenseDao;

	@Autowired
	private ExpenseRepository expenseRepository;

@Override
public Optional<Expense> getExpenseById(Integer cid) {
	Optional<Expense> expenseData=expenseRepository.findById(cid);
	return expenseData;
}

	@Override
	public List<Object> getMonthlyExpense() {
		return expenseDao.getMonthlyExpense();
	}

	@Override
	public List<Object> getUsersMonthlyExpense(Integer id) {
		return expenseDao.getUsersMonthlyExpense(id);
	}
	
	
}
