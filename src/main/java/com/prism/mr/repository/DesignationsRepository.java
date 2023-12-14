package com.prism.mr.repository;

import com.prism.mr.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "designations",collectionResourceRel= "designations",excerptProjection= DesignationProjection.class)
public interface DesignationsRepository extends JpaRepository<Designations,Long>, QuerydslPredicateExecutor<QDesignations> {

    Optional<Designations> findByDesignationCode(String designationCode);
    Optional<Designations> findByDesignationCodeAndIdNotIn(String designationCode, List<Long> Id);
    Optional<Designations> findByDesignationCodeAndIdIn(String designationCode, List<Long> Id);
}
