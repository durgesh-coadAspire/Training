package com.prism.mr.repository;

import com.prism.mr.model.Designations;
import com.prism.mr.model.MemberProjection;
import com.prism.mr.model.Members;
import com.prism.mr.model.QMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(path = "members", collectionResourceRel = "members",excerptProjection= MemberProjection.class)
public interface MembersRepository extends JpaRepository<Members, Long>, QuerydslPredicateExecutor<QMembers> {

    List<Members> findAllByEmployeeId(String employeeId);
    Optional<Members> findByMobile(Long mobile);
    Optional<Members> findByEmployeeId(String employeeId);
    Optional<Members> findByEmployeeIdAndIdNotIn(String employeeId, List<Long> Id);
    Optional<Members> findByEmployeeIdAndIdIn(String employeeId, List<Long> Id);
}


