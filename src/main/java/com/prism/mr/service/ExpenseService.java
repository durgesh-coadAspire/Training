package com.prism.mr.service;

import com.prism.mr.dto.ExpenseDto;
import com.prism.mr.mapper.ExpenseMapper;
import com.prism.mr.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public ExpenseDto addOrUpdateExpense(ExpenseDto expenseDto) {
        return expenseMapper.toDto(expenseRepository.save(expenseMapper.toEntity(expenseDto)));
    }
}
