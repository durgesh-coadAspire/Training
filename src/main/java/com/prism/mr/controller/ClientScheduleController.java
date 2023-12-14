package com.prism.mr.controller;


import com.prism.mr.dto.ClientScheduleDto;
import com.prism.mr.service.ClientScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientScheduleController {

    private final ClientScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ClientScheduleDto> addOrUpdateSchedule(@RequestBody ClientScheduleDto schedulesDto) {
        return new ResponseEntity<>(scheduleService.addOrUpdateSchedule(schedulesDto), HttpStatus.OK);
    }
}
