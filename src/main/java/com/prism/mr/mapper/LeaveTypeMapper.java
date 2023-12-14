package com.prism.mr.mapper;

import com.prism.mr.dto.LeaveTypeDto;
import com.prism.mr.model.LeaveType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveTypeMapper {

    LeaveType toEntity(LeaveTypeDto leaveTypeDto);

    LeaveTypeDto toDto(LeaveType leaveType);
}
