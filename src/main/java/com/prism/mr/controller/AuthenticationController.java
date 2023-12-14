package com.prism.mr.controller;

import com.prism.mr.dto.AuthenticateDto;
import com.prism.mr.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public Map<String, String> authenticateLogin(@RequestBody AuthenticateDto authenticateDto){
        return authenticationService.authenticateLogin(authenticateDto);
    }
}
