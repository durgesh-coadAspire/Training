package com.prism.mr.mapper;

import com.prism.mr.dto.AttendanceDto;
import com.prism.mr.model.Attendance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {
    Attendance toEntity(AttendanceDto attendanceDto);
    AttendanceDto toDo(Attendance attendance);
}
