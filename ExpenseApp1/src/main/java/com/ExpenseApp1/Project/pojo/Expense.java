package com.ExpenseApp1.Project.pojo;

import java.util.Date;




import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "expense" )
public class Expense {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int expenseId;
	private String expense_type;
	private double expense_amount;
	@Temporal(TemporalType.DATE)
	private Date expensedate;
	
	/* ManyToOne Mapping from Multiple Expenses to one user */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	@JsonIgnore
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "categoryId")
	@JsonIgnore
	private Category category;
	public Expense() {
		super();
	}
	public Expense(int expense_id, String expense_type, double expense_amount, Date expensedate) {
		super();
		this.expenseId = expense_id;
		this.expense_type = expense_type;
		this.expense_amount = expense_amount;
		this.expensedate = expensedate;
	}
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int ExpenseId) {
		this.expenseId = ExpenseId;
	}
	public String getExpense_type() {
		return expense_type;
	}
	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}
	public double getExpense_amount() {
		return expense_amount;
	}
	public void setExpense_amount(double expense_amount) {
		this.expense_amount = expense_amount;
	}
	@Temporal(TemporalType.DATE)
	public Date getExpensedate() {
		return expensedate;
	}
	public void setExpensedate(Date expensedate) {
		this.expensedate = expensedate;
	}
	@Override
	public String toString() {
		return "Expense [expense_id=" + expenseId + ", expense_type=" + expense_type + ", expense_amount="
				+ expense_amount + ", expensedate=" + expensedate + "]";
	}
	
	

}
