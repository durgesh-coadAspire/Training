package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.HashMap;

@Projection(name = "schedules",types = {ClientSchedule.class})
public interface ClientScheduleProjection {

    Long getId();
    Long getEmployeeId();
    Long getSchedulerId();
    Long getClientId();
    LocalDateTime getStartAt();
    LocalDateTime getEndAt();
    LocalDateTime getCheckIn();
    HashMap<String, Object> getCheckInLocation();


}
