package com.prism.mr.mapper;

import com.prism.mr.dto.LeaveDto;
import com.prism.mr.model.Leave;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveMapper {

    Leave toEntity(LeaveDto leaveDto);

    LeaveDto toDto(Leave leave);
}
