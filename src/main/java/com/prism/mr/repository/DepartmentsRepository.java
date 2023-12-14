package com.prism.mr.repository;

import com.prism.mr.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "departments", collectionResourceRel = "departments",excerptProjection= DepartmentsProjection.class)
public interface DepartmentsRepository extends JpaRepository<Departments, Long>, QuerydslPredicateExecutor<QDepartments> {

    Optional<Departments> findByDepartmentCode(String departmentCode);
    Optional<Departments> findByDepartmentCodeAndIdNotIn(String departmentCode, List<Long> Id);

    Optional<Departments> findByDepartmentCodeAndIdIn(String departmentCode, List<Long> Id);

}
