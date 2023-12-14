package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(
        name = "members",
        types = {Members.class})
public interface MemberProjection {

    Long getId();

    String getEmployeeId();

    String getFirstName();

    String getLastName();

    String getEmail();

    Long getMobile();

    LocalDate getDob();

    LocalDate getJoiningDate();

    Long getDesignation();

}
