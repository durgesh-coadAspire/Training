package com.prism.mr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDto {
    private Long id;

    private String departmentCode;
    private String departmentName;
    private Long departmentHead;

}
