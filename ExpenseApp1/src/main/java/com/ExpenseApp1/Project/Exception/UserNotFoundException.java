package com.ExpenseApp1.Project.Exception;

public class UserNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 8141783047011782570L;

public UserNotFoundException(String msg )
{
	super(msg);
}
}