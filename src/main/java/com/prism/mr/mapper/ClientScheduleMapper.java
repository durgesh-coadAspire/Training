package com.prism.mr.mapper;


import com.prism.mr.dto.ClientScheduleDto;
import com.prism.mr.model.ClientSchedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientScheduleMapper {

    ClientSchedule toEntity(ClientScheduleDto schedulesDto);

    ClientScheduleDto toDto(ClientSchedule schedules);

}
