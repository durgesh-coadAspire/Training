package com.prism.mr.mapper;

import com.prism.mr.dto.DesignationsDto;
import com.prism.mr.model.Designations;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DesignationsMapper {

    Designations toEntity(DesignationsDto designationsDto);
    DesignationsDto toDto(Designations designations);

}
