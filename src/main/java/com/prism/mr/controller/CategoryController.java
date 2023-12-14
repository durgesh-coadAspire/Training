package com.prism.mr.controller;

import com.prism.mr.dto.CategoryDto;
import com.prism.mr.dto.ClientsDto;
import com.prism.mr.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @PostMapping("/category")
    public ResponseEntity<CategoryDto> addOrUpdateCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.addOrUpdateCategory(categoryDto), HttpStatus.OK);
    }
    @GetMapping("/category/validate/categoryCode")
    public ResponseEntity<String> validateCategoryCode(@RequestParam(required = false) Long Id, @RequestParam String Code) {
        return new ResponseEntity<>(categoryService.validateCategoryCode(Id,Code), HttpStatus.OK);
    }
}
