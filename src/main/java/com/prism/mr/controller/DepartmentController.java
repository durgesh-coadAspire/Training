package com.prism.mr.controller;

import com.prism.mr.dto.DepartmentDto;
import com.prism.mr.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/departments")
    public ResponseEntity<DepartmentDto> addOrUpdateDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.addOrUpdate(departmentDto), HttpStatus.OK);
    }
    @GetMapping("/departments/validate/departmentCode")
    public ResponseEntity<String> validateDepartmentCode(@RequestParam(required = false) Long Id, @RequestParam String Code) {
        return new ResponseEntity<>(departmentService.validateDepartmentCode(Id,Code), HttpStatus.OK);
    }
}
