package com.prism.mr.service;

import com.prism.mr.dto.LeaveDto;
import com.prism.mr.mapper.LeaveMapper;
import com.prism.mr.repository.LeaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaveService {

    private final LeaveRepository leaveRepository;
    private final LeaveMapper leaveMapper;

    public LeaveDto addOrUpdateLeave(LeaveDto leaveDto)
    {
        return leaveMapper.toDto(leaveRepository.save(leaveMapper.toEntity(leaveDto)));
    }
}
