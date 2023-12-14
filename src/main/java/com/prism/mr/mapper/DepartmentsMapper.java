package com.prism.mr.mapper;

import com.prism.mr.dto.DepartmentDto;
import com.prism.mr.model.Departments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentsMapper {
    Departments toEntity(DepartmentDto departmentDto);

    DepartmentDto toDo(Departments departments);
}
