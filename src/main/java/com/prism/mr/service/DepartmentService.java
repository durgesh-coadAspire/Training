package com.prism.mr.service;

import com.prism.mr.dto.DepartmentDto;
import com.prism.mr.exception.ResourceNotFoundException;
import com.prism.mr.mapper.DepartmentsMapper;
import com.prism.mr.model.Departments;
import com.prism.mr.model.Members;
import com.prism.mr.repository.DepartmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    @Autowired
    private DepartmentsRepository departmentsRepository;
    @Autowired
    private DepartmentsMapper departmentsMapper;

    public DepartmentDto addOrUpdate(DepartmentDto departmentDto) {
        return departmentsMapper.toDo(departmentsRepository.save(departmentsMapper.toEntity(departmentDto)));
    }

    public String validateDepartmentCode(Long Id, String Code) {
        Optional<Departments> departments;
        if(Id==null )
        {
            departments=departmentsRepository.findByDepartmentCode(Code);
        }
        else {
            departments=departmentsRepository.findById(Id);
            if(departments.isPresent())
            {
                if(departmentsRepository.findById(Id).get().getDepartmentCode().equalsIgnoreCase(Code))
                {
                    departments=departmentsRepository.findByDepartmentCodeAndIdIn(Code,List.of(Id));
                }
                else {
                    departments=departmentsRepository.findByDepartmentCodeAndIdNotIn(Code,List.of(Id));
                }
            }
            else {
                departments=departmentsRepository.findByDepartmentCodeAndIdNotIn(Code,List.of(Id));
            }

        }
        if(departments.isPresent())
        {
            throw new ResourceNotFoundException("Duplicate Department Code Found !!");
        }
        else {
            return "VALID DEPARTMENT CODE";
        }

    }
}
