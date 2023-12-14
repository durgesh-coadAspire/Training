package com.prism.mr.service;

import com.prism.mr.dto.CategoryDto;
import com.prism.mr.exception.ResourceNotFoundException;
import com.prism.mr.mapper.CategoryMapper;
import com.prism.mr.model.Category;
import com.prism.mr.model.Departments;
import com.prism.mr.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryDto addOrUpdateCategory(CategoryDto categoryDto)
    {
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(categoryDto)));
    }

    public String validateCategoryCode(Long Id, String Code) {
        Optional<Category> category;
        if(Id==null )
        {
            category=categoryRepository.findByCategoryCode(Code);
        }
        else {
            category=categoryRepository.findById(Id);
            if(category.isPresent())
            {
                if(categoryRepository.findById(Id).get().getCategoryCode().equalsIgnoreCase(Code))
                {
                    category=categoryRepository.findByCategoryCodeAndIdIn(Code,List.of(Id));
                }
                else {
                    category=categoryRepository.findByCategoryCodeAndIdNotIn(Code,List.of(Id));
                }
            }
            else {
                category=categoryRepository.findByCategoryCodeAndIdNotIn(Code,List.of(Id));
            }

        }
        if(category.isPresent())
        {
            throw new ResourceNotFoundException("Duplicate Category Code Found !!");
        }
        else {
            return "VALID CATEGORY CODE";
        }

    }

}
