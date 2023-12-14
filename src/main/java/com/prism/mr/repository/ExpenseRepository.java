package com.prism.mr.repository;

import com.prism.mr.model.Expense;
import com.prism.mr.model.ExpenseProjection;
import com.prism.mr.model.QExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "expense",collectionResourceRel= "expense",excerptProjection= ExpenseProjection.class)
public interface ExpenseRepository extends JpaRepository<Expense, Long>, QuerydslPredicateExecutor<QExpense> {
}
