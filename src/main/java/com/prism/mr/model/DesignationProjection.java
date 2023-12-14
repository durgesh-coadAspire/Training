package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "designation",types = Designations.class)
public interface DesignationProjection {
    Long getId();
    String getDesignationCode();
    String getDesignationName();

}
