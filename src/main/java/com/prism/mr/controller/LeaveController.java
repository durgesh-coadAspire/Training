package com.prism.mr.controller;

import com.prism.mr.dto.CategoryDto;
import com.prism.mr.dto.LeaveDto;
import com.prism.mr.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LeaveController {

    private final LeaveService leaveService;

    @PostMapping("/leaves")
    public ResponseEntity<LeaveDto> addOrUpdateLeave(@RequestBody LeaveDto leaveDto) {
        return new ResponseEntity<>(leaveService.addOrUpdateLeave(leaveDto), HttpStatus.OK);
    }
}
