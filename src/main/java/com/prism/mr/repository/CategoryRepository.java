package com.prism.mr.repository;

import com.prism.mr.model.Category;
import com.prism.mr.model.CategoryProjection;
import com.prism.mr.model.Members;
import com.prism.mr.model.QCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "category",collectionResourceRel= "category",excerptProjection= CategoryProjection.class)
public interface CategoryRepository extends JpaRepository<Category,Long>, QuerydslPredicateExecutor<QCategory> {

    Optional<Category> findByCategoryCode(String categoryCode);
    Optional<Category> findByCategoryCodeAndIdNotIn(String categoryCode, List<Long> Id);
    Optional<Category> findByCategoryCodeAndIdIn(String categoryCode,List<Long> Id);
}
