package com.ExpenseApp1.Project.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpenseApp1.Project.Dao.IUserDao;

import com.ExpenseApp1.Project.Exception.UserNotFoundException;
import com.ExpenseApp1.Project.pojo.User;


@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;

	@Override
	public String registerUser(User user) {
		
		return userDao.registerUser(user);
	}

	@Override
	public User loginUser(String Email, String Password) {
		
		User user=userDao.loginUser(Email,Password);
		if(user==null)
		{
			throw new UserNotFoundException("msg");
		}
		return userDao.loginUser(Email, Password);
	}
	
	

	@Override
	public List<User> usersList() {
		
		return  userDao.usersList();
	}
	

	@Override
	public User getByUserIdAndName(Integer id, String name) {
		
		return userDao.getByUserIdAndUserName(id,name);
	}
	
	
	

}
