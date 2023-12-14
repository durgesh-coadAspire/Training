package com.prism.mr.repository;

import com.prism.mr.dto.MemberPermissionDto;
import com.prism.mr.model.MemberPermission;
import com.prism.mr.model.MemberPermissionId;
import com.prism.mr.model.QMemberPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "memberPermission", collectionResourceRel = "member/permission")
public interface MemberPermissionRepository extends JpaRepository<MemberPermission, MemberPermissionId>, QuerydslPredicateExecutor<QMemberPermission> {

    void deleteAllByMemberId(Long memberId);

    @Query("select new com.prism.mr.dto.MemberPermissionDto(permission.id,permission.name,permission.code,permission.permissionGroupId,permission.sequence) From MemberPermission memberPermission , Permission permission Where memberPermission.permissionId = permission.id and memberPermission.memberId =:memberId order by permission.permissionGroupId,permission.sequence ASC")
    List<MemberPermissionDto> getAllPermissionForMember(Long memberId);
}
