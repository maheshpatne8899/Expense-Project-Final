package com.ExpenseApp1.Project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ExpenseApp1.Project.pojo.Expense;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
	Optional<Expense> findByExpenseId(@Param("cid") Integer cid);

}
