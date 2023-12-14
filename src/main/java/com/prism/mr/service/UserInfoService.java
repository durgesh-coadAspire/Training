package com.prism.mr.service;

import com.prism.mr.config.UserInfo;
import com.prism.mr.exception.ResourceNotFoundException;
import com.prism.mr.model.Members;
import com.prism.mr.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserDetailsService {
    public UserInfoService() {

    }

    @Autowired
    private MembersRepository membersRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Members member = membersRepository.findById(Long.valueOf(userId)).orElseThrow(() -> new ResourceNotFoundException("Invalid User"));
        UserInfo userInfo = new UserInfo(member);
        return userInfo;
    }
}
