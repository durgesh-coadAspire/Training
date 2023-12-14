package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "departments",
types = {Departments.class})
public interface DepartmentsProjection {
    Long getId();
    String getDepartmentCode();
    String getDepartmentName();
    Long getDepartmentHead();

}
