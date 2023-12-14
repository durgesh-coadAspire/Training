package com.prism.mr.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthenticateDto {
    private Long mobile;
    private String password;
}
