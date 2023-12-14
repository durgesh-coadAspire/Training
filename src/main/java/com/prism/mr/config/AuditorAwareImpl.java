package com.prism.mr.config;

import com.prism.mr.model.Members;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;
import java.util.Optional;

@NoArgsConstructor
@Slf4j
public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (Objects.nonNull(authentication) && authentication.getPrincipal() instanceof Members) {
                Members members = (Members) authentication.getPrincipal();
                log.debug("Auditing Through Token - {}", members.getId());
                return Optional.of(members.getId());
            }

        } catch (Exception exception) {
            log.error("Error while getting auditor User Id", exception);
        }
        return Optional.of(0L);
    }

}