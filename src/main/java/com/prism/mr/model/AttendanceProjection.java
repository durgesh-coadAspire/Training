package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.HashMap;

@Projection(name = "attendance", types = {Attendance.class})
public interface AttendanceProjection {
    Long getId();
    Long getMemberId();
    LocalDateTime getCheckIn();
    HashMap<String, Object> getCheckInLocation();
    LocalDateTime getCheckOut();
    HashMap<String, Object> getCheckOutLocation();
}
