package com.prism.mr.mapper;

import com.prism.mr.dto.CategoryDto;
import com.prism.mr.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDto categoryDto);
    CategoryDto toDto(Category category);
}
