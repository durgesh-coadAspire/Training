package com.prism.mr.repository;

import com.prism.mr.model.Permission;
import com.prism.mr.model.QPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "permission", collectionResourceRel = "permission")
public interface PermissionRepository extends JpaRepository<Permission, Long>, QuerydslPredicateExecutor<QPermission> {

    List<Permission> findAllByIdNotIn(List<Long> ids);
}
