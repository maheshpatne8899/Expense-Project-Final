package com.ExpenseApp1.Project.Service;

import java.util.List;
import java.util.Optional;
import com.ExpenseApp1.Project.pojo.Expense;

public interface IExpenseService {

public Optional<Expense> getExpenseById(Integer cid);

public List<Object> getMonthlyExpense();

public List<Object> getUsersMonthlyExpense(Integer id);


}
