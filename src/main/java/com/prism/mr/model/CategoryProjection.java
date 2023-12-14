package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "category",types = {Category.class})
public interface CategoryProjection {
    Long getId();
    String getCategoryCode();
    String getCategoryName();

}
