package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;
import java.util.HashMap;

@Projection(name = "expense", types = {Expense.class})
public interface ExpenseProjection {

    Long getId();
    String getSpentAt();
    LocalDate getDate();
    String getAmount();
    HashMap<String, String> getLocation();
    String getRemark();
}
