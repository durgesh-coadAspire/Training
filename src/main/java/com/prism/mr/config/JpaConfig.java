package com.prism.mr.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@Slf4j
public class JpaConfig {

    @Bean
    public AuditorAware<Long> auditorAware() {
        return new com.prism.mr.config.AuditorAwareImpl();
    }

}