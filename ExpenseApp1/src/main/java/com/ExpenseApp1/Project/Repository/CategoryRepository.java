package com.ExpenseApp1.Project.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ExpenseApp1.Project.pojo.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{
	Optional<String> findBycategoryName(@Param("name") String name);
	Optional<Category> findByCategoryId(@Param("cid") Integer cid);

}