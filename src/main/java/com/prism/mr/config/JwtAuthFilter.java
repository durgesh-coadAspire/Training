package com.prism.mr.config;

import com.prism.mr.model.Members;
import com.prism.mr.service.MemberService;
import com.prism.mr.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;

    private final MemberService memberService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String userId = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            userId = jwtTokenUtil.getIdFromToken(token);
        }

        if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Members userDetails = memberService.findByUserId(userId);
            if (jwtTokenUtil.validateToken(token, userDetails)) {
                Claims claims = jwtTokenUtil.getAllClaimsFromToken(token);
                List<? extends GrantedAuthority> authorities = new ArrayList<>();
                if (claims.containsKey("permissions")) {
                    List<String> permissionList = (ArrayList<String>) claims.get("permissions");
                    authorities = permissionList.stream().map(permission -> {
                        return JwtAuthFilter.getAuthority(permission);
                    }).collect(Collectors.toList());
                }
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    private static SimpleGrantedAuthority getAuthority(String s) {
        return new SimpleGrantedAuthority("ROLE_" + s);
    }
}