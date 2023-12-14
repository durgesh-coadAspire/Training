package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "clients",
types = {Clients.class})
public interface ClientsProjection {
    Long getId();
    String getClientCode();
    String getClientLastName();
    String getEmail();
    Long getMobile();
    String getGender();
    String getCategory();
    String getRegion();
}
