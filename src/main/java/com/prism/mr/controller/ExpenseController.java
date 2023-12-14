package com.prism.mr.controller;

import com.prism.mr.dto.ExpenseDto;
import com.prism.mr.model.Expense;
import com.prism.mr.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;
    @PostMapping("/expense")
    public ResponseEntity<ExpenseDto> addOrUpdateExpense(@RequestBody ExpenseDto expenseDto){
        return new ResponseEntity<>(expenseService.addOrUpdateExpense(expenseDto), HttpStatus.OK);
    }
}
