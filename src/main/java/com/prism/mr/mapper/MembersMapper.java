package com.prism.mr.mapper;

import com.prism.mr.dto.MembersDto;
import com.prism.mr.model.Members;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MembersMapper {

    @Mapping(target = "password",ignore = true)
    Members toEntity(MembersDto membersDto);

    MembersDto toDto(Members members);

}
