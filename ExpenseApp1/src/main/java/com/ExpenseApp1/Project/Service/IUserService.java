package com.ExpenseApp1.Project.Service;

import java.util.List;

import com.ExpenseApp1.Project.pojo.User;

public interface IUserService {
	
	public String registerUser(User  user);
	
	public User loginUser(String email,String Password);

	public List<User> usersList();

	public User getByUserIdAndName(Integer id, String name);

}
