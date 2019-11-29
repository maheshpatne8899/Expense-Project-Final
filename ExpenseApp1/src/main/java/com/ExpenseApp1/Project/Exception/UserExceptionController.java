package com.ExpenseApp1.Project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception)
	{
		return new ResponseEntity<Object>("User does not existed",HttpStatus.NOT_FOUND);
	}

}
