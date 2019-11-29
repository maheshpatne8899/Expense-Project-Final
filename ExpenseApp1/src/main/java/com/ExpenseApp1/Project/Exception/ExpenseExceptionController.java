package com.ExpenseApp1.Project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExpenseExceptionController {
	
	@ExceptionHandler(ExpenseNotFoundException.class)
	public ResponseEntity<Object> exception(ExpenseNotFoundException exception)
	{
		return new ResponseEntity<Object>("Expense does not existed",HttpStatus.NOT_FOUND);
	}

}
