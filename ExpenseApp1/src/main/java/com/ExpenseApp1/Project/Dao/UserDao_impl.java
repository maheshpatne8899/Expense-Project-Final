package com.ExpenseApp1.Project.Dao;


import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ExpenseApp1.Project.pojo.User;



@Repository
@Transactional
public class UserDao_impl implements IUserDao
{

	
	@PersistenceContext
	private EntityManager entityManger;
	
	@Override
	public String registerUser(User user) {
	entityManger.persist(user);
		return "Successfully Registered";
	}

	@Override
	public User loginUser(String Email, String Password) {
		
		CriteriaBuilder cb=entityManger.getCriteriaBuilder();
		CriteriaQuery<User> cq=cb.createQuery(User.class);
		Root<User> user=cq.from(User.class);
		Predicate emailPredicate=cb.equal(user.get("email"),Email);
		Predicate passwordPredicate=cb.like(user.get("password"),Password);
		cq.where(emailPredicate,passwordPredicate);
		TypedQuery<User> query=entityManger.createQuery(cq);		
		return query.getSingleResult();
	}
	
	

	@Override
	public List<User> usersList() {
		
		CriteriaBuilder cb=entityManger.getCriteriaBuilder();
		CriteriaQuery<User>cq=cb.createQuery(User.class);
		Root<User>users=cq.from(User.class);
		CriteriaQuery<User> select=cq.select(users);
		TypedQuery<User> tq=entityManger.createQuery(select);
		List<User>users_List=tq.getResultList();
		return users_List;
	}
	
	
	@Override
	public User getByUserIdAndUserName(Integer id, String name) {
		CriteriaBuilder cb=entityManger.getCriteriaBuilder();
		CriteriaQuery<User> cq=cb.createQuery(User.class);
		Root<User> user=cq.from(User.class);
		Predicate userIdPredicate=cb.equal(user.get("userId"),id);
		Predicate userNamePredicate=cb.like(user.get("username"),name);
		cq.where(userIdPredicate,userNamePredicate);
		TypedQuery<User> query=entityManger.createQuery(cq);
		return query.getSingleResult();
	}


}
