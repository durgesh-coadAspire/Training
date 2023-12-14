package com.prism.mr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member_permission")
@IdClass(MemberPermissionId.class)
public class MemberPermission {

    @Id
    private Long permissionId;

    @Id
    private Long memberId;
}
