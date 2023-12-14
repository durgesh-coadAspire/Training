package com.prism.mr.controller;

import com.prism.mr.dto.AttendanceDto;
import com.prism.mr.dto.DesignationsDto;
import com.prism.mr.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/attendance")
    public ResponseEntity<AttendanceDto> addOrUpdateAttendance(@RequestBody AttendanceDto attendanceDto) {
        return new ResponseEntity<>(attendanceService.addOrUpdateAttendance(attendanceDto), HttpStatus.OK);
    }
}
