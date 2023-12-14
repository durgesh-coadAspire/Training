package com.prism.mr.service;

import com.prism.mr.dto.AttendanceDto;
import com.prism.mr.mapper.AttendanceMapper;
import com.prism.mr.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;
    public AttendanceDto addOrUpdateAttendance(AttendanceDto attendanceDto){
        return attendanceMapper.toDo(attendanceRepository.save(attendanceMapper.toEntity(attendanceDto)));
    }
}
