package com.prism.mr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Departments extends BaseEntity {
    @Column(unique = true,nullable = false)
    private String departmentCode;
    private String departmentName;
    private Long departmentHead;

}
