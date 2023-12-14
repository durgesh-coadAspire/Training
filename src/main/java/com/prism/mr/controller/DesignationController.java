package com.prism.mr.controller;

import com.prism.mr.dto.ClientsDto;
import com.prism.mr.dto.DesignationsDto;
import com.prism.mr.service.ClientService;
import com.prism.mr.service.DesignationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DesignationController {
    private final DesignationService designationService;
    @PostMapping("/designations")
    public ResponseEntity<DesignationsDto> addOrUpdateDesignation(@RequestBody DesignationsDto designationsDto) {
        return new ResponseEntity<>(designationService.addOrUpdateDesignation(designationsDto), HttpStatus.OK);
    }

    @GetMapping("/designations/validate/designationCode")
    public ResponseEntity<String> validateDesignationCode(@RequestParam(required = false) Long Id, @RequestParam String Code) {
        return new ResponseEntity<>(designationService.validateDesignationCode(Id,Code), HttpStatus.OK);
    }
}
