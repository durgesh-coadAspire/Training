package com.prism.mr.repository;

import com.prism.mr.model.Leave;
import com.prism.mr.model.LeaveProjection;
import com.prism.mr.model.QLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "leaves", collectionResourceRel = "leaves",excerptProjection= LeaveProjection.class)
public interface LeaveRepository extends JpaRepository<Leave,Long>, QuerydslPredicateExecutor<QLeave> {
}
