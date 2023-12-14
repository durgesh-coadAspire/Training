package com.prism.mr.service;

import com.prism.mr.dto.DesignationsDto;
import com.prism.mr.exception.ResourceNotFoundException;
import com.prism.mr.mapper.DesignationsMapper;
import com.prism.mr.model.Departments;
import com.prism.mr.model.Designations;
import com.prism.mr.repository.DesignationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DesignationService {

    private final DesignationsRepository designationsRepository;
    private final DesignationsMapper designationsMapper;

    public DesignationsDto addOrUpdateDesignation(DesignationsDto designationsDto) {
        return designationsMapper.toDto(designationsRepository.save(designationsMapper.toEntity(designationsDto)));
    }
    public String validateDesignationCode(Long Id, String Code) {
        Optional<Designations> designations;
        if(Id==null )
        {
            designations=designationsRepository.findByDesignationCode(Code);
        }
        else {
            designations=designationsRepository.findById(Id);
            if(designations.isPresent())
            {
                if(designationsRepository.findById(Id).get().getDesignationCode().equalsIgnoreCase(Code))
                {
                    designations=designationsRepository.findByDesignationCodeAndIdIn(Code,List.of(Id));
                }
                else {
                    designations=designationsRepository.findByDesignationCodeAndIdNotIn(Code,List.of(Id));
                }
            }
            else {
                designations=designationsRepository.findByDesignationCodeAndIdNotIn(Code,List.of(Id));
            }
        }
        if(designations.isPresent())
        {
            throw new ResourceNotFoundException("Duplicate Designation Code Found !!");
        }
        else {
            return "VALID DESIGNATION CODE";
        }

    }

}
