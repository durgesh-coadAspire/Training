package com.prism.mr.service;

import com.prism.mr.dto.ClientScheduleDto;
import com.prism.mr.mapper.ClientScheduleMapper;
import com.prism.mr.repository.ClientScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientScheduleService {

    private final ClientScheduleMapper schedulesMapper;
    private final ClientScheduleRepository schedulesRepository;

    public ClientScheduleDto addOrUpdateSchedule(ClientScheduleDto schedulesDto) {
        return schedulesMapper.toDto(schedulesRepository.save(schedulesMapper.toEntity(schedulesDto)));
    }
}
