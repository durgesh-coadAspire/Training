package com.prism.mr.mapper;

import com.prism.mr.dto.ExpenseDto;
import com.prism.mr.model.Expense;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {
    Expense toEntity(ExpenseDto expenseDto);
    ExpenseDto toDto(Expense expense);
}
