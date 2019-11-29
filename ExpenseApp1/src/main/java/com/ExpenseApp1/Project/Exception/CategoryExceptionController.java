package com.ExpenseApp1.Project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryExceptionController {
	/**
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<Object> exception(CategoryNotFoundException exception)
	{
		return new ResponseEntity<Object>("Category does not exixited",HttpStatus.NOT_FOUND);
	}
	

}
