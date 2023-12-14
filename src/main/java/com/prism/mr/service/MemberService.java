package com.prism.mr.service;

import com.prism.mr.dto.MembersDto;
import com.prism.mr.exception.ResourceNotFoundException;
import com.prism.mr.mapper.MembersMapper;
import com.prism.mr.model.Members;
import com.prism.mr.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MembersRepository membersRepository;
    private final MembersMapper membersMapper;
    private final PasswordEncoder passwordEncoder;


    public MembersDto addOrUpdateMember(MembersDto membersDto) {
        Members members = new Members();
        if(Objects.nonNull(membersDto.getId())){
            members  = membersRepository.findById(membersDto.getId()).orElse(new Members());
        }
        BeanUtils.copyProperties(membersDto,members,"password");
        if(Objects.isNull(members.getId())){
            members.setPassword(passwordEncoder.encode(membersDto.getPassword()));
        }
       return membersMapper.toDto(membersRepository.save(members));
    }

    public Members findByUserId(String userId){
        return membersRepository.findById(Long.valueOf(userId)).orElseThrow(()-> new ResourceNotFoundException("Invalid User"));
    }

    public String validateEmployeeId(Long Id, String Code) {
        Optional<Members> members;
        if(Id==null )
        {
            members=membersRepository.findByEmployeeId(Code);
        }
        else {
            members=membersRepository.findById(Id);
            if(members.isPresent())
            {
                if(membersRepository.findById(Id).get().getEmployeeId().equalsIgnoreCase(Code))
                {
                    members=membersRepository.findByEmployeeIdAndIdIn(Code,List.of(Id));
                }
                else {
                    members=membersRepository.findByEmployeeIdAndIdNotIn(Code,List.of(Id));
                }
            }
            else {
                members=membersRepository.findByEmployeeIdAndIdNotIn(Code,List.of(Id));
            }
        }
        if(members.isPresent())
        {
            throw new ResourceNotFoundException("Duplicate Employee ID Found !!");
        }

        else {
            return "VALID EMPLOYEE CODE";
        }
    }

}
