package com.prism.mr.service;

import com.prism.mr.dto.AuthenticateDto;
import com.prism.mr.exception.ResourceNotFoundException;
import com.prism.mr.model.Members;
import com.prism.mr.repository.MembersRepository;
import com.prism.mr.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtTokenUtil jwtTokenUtil;
    private final MembersRepository membersRepository;
    private final PasswordEncoder passwordEncoder;

    public Map<String, String> authenticateLogin(AuthenticateDto authenticateDto) {
        if(StringUtils.isEmpty(authenticateDto.getPassword())|| Objects.isNull(authenticateDto.getMobile())){
            throw new ResourceNotFoundException("Invalid Mobile Or Password !");
        }
       Optional<Members> member  = membersRepository.findByMobile(authenticateDto.getMobile());
        if(member.isPresent()) {
            if(passwordEncoder.matches(authenticateDto.getPassword(),member.get().getPassword())) {
                return jwtTokenUtil.generateToken(member.get());
            }else{
                throw new ResourceNotFoundException("Invalid Mobile Or Password !");
            }
        }else {
            throw new ResourceNotFoundException("Invalid Mobile Or Password !");
        }
    }
}
