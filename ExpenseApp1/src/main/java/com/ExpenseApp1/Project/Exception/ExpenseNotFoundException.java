package com.ExpenseApp1.Project.Exception;

public class ExpenseNotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = -1442431295765157424L;

	public ExpenseNotFoundException(String msg )
	{
		super(msg);
	}

}
