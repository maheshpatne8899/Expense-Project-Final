package com.ExpenseApp1.Project.pojo;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ExpenseApp1.Project.pojo.Expense;
import com.ExpenseApp1.Project.pojo.User;




@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	
	private String username;
	private String email;
	private String password;
	private String confirmPassword;

	/* OneToMany Mapping from one User to multiple Expenses */

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//@JsonIgnore
private List<Expense> expense=new ArrayList<Expense>();

public List<Expense> getExpense() {
return expense;
}

public void setExpense(List<Expense> expense) {
this.expense = expense;
}
	public User() {
		super();
	}
	public User(int userid, String username, String email, String password, String confirmPassword) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + "]";
	}
	

}
