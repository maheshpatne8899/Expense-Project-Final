package com.ExpenseApp1.Project.Exception;

public class CategoryNotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1577126991048316768L;

	public CategoryNotFoundException(String msg )
	{
		super(msg);
	}

}
