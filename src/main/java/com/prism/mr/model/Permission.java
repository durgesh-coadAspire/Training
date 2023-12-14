package com.prism.mr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "permission")
public class Permission extends BaseEntity{
    private String name;
    @Column(nullable = false, unique = true)
    private String code;
    private String permissionGroupId;
    private Long sequence;
}
