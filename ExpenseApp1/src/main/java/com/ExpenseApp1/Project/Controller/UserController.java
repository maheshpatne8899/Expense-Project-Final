package com.ExpenseApp1.Project.Controller;

import com.ExpenseApp1.Project.EmailProject.SmtpMailSender;
import com.ExpenseApp1.Project.Exception.UserNotFoundException;
import com.ExpenseApp1.Project.Service.IUserService;
import com.ExpenseApp1.Project.pojo.User;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@Autowired 
	SmtpMailSender smtpMailSender;

	
	/**
	 * Method used for user registration
	 * @param user details (user object)
	 * @return status string
	 */
	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody User user)
	{
		try {
		if(user.getPassword().equals(user.getConfirmPassword()))
	 {	
		ResponseEntity<String> status =new ResponseEntity<String>(userService.registerUser(user),HttpStatus.OK);
		ResponseEntity<String> statusCheck =new ResponseEntity<String>("Successfully Registered",HttpStatus.OK);
		
		  if (statusCheck.equals(status)) 
		  {
			smtpMailSender.send("maheshpatne7059@gmail.com", user.getUsername()+ " registed",
			"Mail of user registration");
			return status;
			
			}
		}

              return new ResponseEntity<String>("password dosen't match", HttpStatus.INTERNAL_SERVER_ERROR);
		
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Registreration failed ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }

	

	/**
	 * Method used for login user
	 * @param String emailId and password
	 * @return User Details (Entire Object)
	 */
	@GetMapping("/loginuser")
	public ResponseEntity<?>loginUser(@RequestBody User user, HttpSession hs)
	{
	try {
	
		User validUser = userService.loginUser(user.getEmail(),user.getPassword());
	      hs.setAttribute("validUser", validUser);
	      return new ResponseEntity<User>(validUser, HttpStatus.OK);
		
	}
	catch(Exception e)
	{
		throw new UserNotFoundException("user not found");
	}
	}
	

	/**
	 * Method used to get registered users list
	 * @param No any parameter provided
	 * @return List of registered Users
	 */
	@GetMapping("/userslist")
	public List<User> usersList()
	{
		return userService.usersList();
	}
	
	
	/**
	 * Method used to get User 
	 * @param UserId and UserName
	 * @return User Details (User Object)
	 */
	@GetMapping("/getUserByIdAndName")
	public User getByUserIdAndUserName(@RequestBody User user)
	{
		Integer id=user.getUserid();
		String name=user.getUsername();
		return userService.getByUserIdAndName(id,name);
		
	}
	
	


}
