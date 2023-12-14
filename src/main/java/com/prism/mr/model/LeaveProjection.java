package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "leaves",types = {Leave.class})
public interface LeaveProjection {

    Long getId();
    Long getEmployeeId();
    Long getLeaveType();
    LocalDate getStartAt();
    LocalDate getEndAt();
    String getReason();
    Integer getStatus();
    Double getDuration();
    Long getActionBY();
    String getRemarks();
    Boolean getHalfDay();


}
