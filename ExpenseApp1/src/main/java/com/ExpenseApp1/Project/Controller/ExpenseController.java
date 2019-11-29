package com.ExpenseApp1.Project.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseApp1.Project.Dto.ExpenseDto;
import com.ExpenseApp1.Project.Exception.ExpenseNotFoundException;
import com.ExpenseApp1.Project.Repository.ExpenseRepository;
import com.ExpenseApp1.Project.Service.IExpenseService;

import com.ExpenseApp1.Project.pojo.Expense;


@RestController
@RequestMapping("/expense")
public class ExpenseController {
	@Autowired
	IExpenseService expenseService;
	@Autowired
	private ExpenseRepository expenseRepository;
	

	/**
	 * Method used to add Expense 
	 * @param Expense 
	 * @return status string
	 */
	
	@PostMapping("/addexpense")
	public Expense addExpense(@RequestBody ExpenseDto expensedto)
	{
		
		Expense exp=new Expense();
		exp.setExpenseId(expensedto.getExpenseId());
		exp.setExpense_type(expensedto.getExpense_type());
		
		exp.setExpense_amount(expensedto.getExpense_amount());
		exp.setExpensedate(expensedto.getExpensedate());
		
		return expenseRepository.save(exp);
	
	}
	

	/**
	 * Method used to fetch ExpenseList 
	 * @param Expense (Parameter not needed but added for some other purpose)  
	 * @return Expense List
	 */
	@GetMapping("/expenselist")	
	 public ResponseEntity<List<Expense>>getExpenseList()
		 {
			
			return ResponseEntity.ok().body(expenseRepository.findAll());
	     }
	
	
	/**
	 * Method used to display monthly expense amount 
	 * @param  
	 * @return Expense Amount List
	 */
	@GetMapping("/monthlyExpense")	
	 public ResponseEntity<List<Object>> getMonthlyExpense()
		 {
		return new ResponseEntity<List<Object>>(expenseService.getMonthlyExpense(),HttpStatus.OK);
	     }
	
	
	/**
	 * Method used to display monthly expense amount of specific user
	 * @param Integer id 
	 * @return Expense Amount List
	 */
	@GetMapping("/monthlyExpense/{id}")
	public ResponseEntity<List<Object>> getUsersMonthlyExpense(@PathVariable("id") Integer id)
	{
		return new ResponseEntity<List<Object>>(expenseService.getUsersMonthlyExpense(id),HttpStatus.OK);
	}

	

	/**
	 * Method used to fetch ExpenseList of specific user
	 * @param Integer id 
	 * @return Expense List
	 */
	@GetMapping("/expenselist/{id}")
	public Optional<Expense> getExpenseById(@PathVariable("id") Integer id)
	{
		try
		{
		Optional<Expense> expenseData=expenseService.getExpenseById(id);
		return expenseData;
		}
		
		
		catch (Exception e) 
		{
			throw new ExpenseNotFoundException("Expense Not Found");
		}
	}
	
	
	
	/**
	 * Method used to Update user
	 * @param Integer id 
	 * @return Updated User
	 */
	  @PutMapping("/expenselist/{id}")	
		ResponseEntity<Expense> updateExpense(@Valid @RequestBody Expense expense)	{
			Expense result=expenseRepository.save(expense);
		return ResponseEntity.ok().body(result);
			}
		
	  
	  
	  /**
		 * Method used to Delete user
		 * @param Integer id 
		 * @return Null
		 */
	  @DeleteMapping("/expense/{id}")
	  ResponseEntity<?> deleteCategory(@PathVariable Integer id)
	  {
	  	expenseRepository.deleteById(id);
	  	return ResponseEntity.ok().build();
	  }

}
