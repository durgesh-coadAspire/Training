package com.prism.mr.util;

import com.prism.mr.dto.MemberPermissionDto;
import com.prism.mr.model.Members;
import com.prism.mr.service.PermissionService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;
import org.springframework.util.CollectionUtils;

@Component
@Slf4j
public class JwtTokenUtil {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.validity}")
    private long JWT_TOKEN_VALIDITY;

    @Autowired
    private PermissionService permissionService;

    public Map<String, String> generateToken(Members user) {
        Map<String, String> jwtTokenGen = new HashMap<>();

        try {
            String jwtToken = "";
            Claims claims  = Jwts.claims().setSubject(String.valueOf(user.getId())).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000));
            claims.put("mobile", user.getMobile().toString());
            List<String> permissions = permissionService.getAllPermissionForMember(user.getId()).stream().map(MemberPermissionDto::getCode).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(permissions)) {
                claims.put("permissions",permissions);
            }
            jwtToken = Jwts.builder().setClaims(claims)
                    .signWith(SignatureAlgorithm.HS512, secret).compact();
            jwtTokenGen.put("token", jwtToken);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return jwtTokenGen;
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date(System.currentTimeMillis()));
    }

    //validate token
    public Boolean validateToken(String token, Members userDetails) {
        final Claims claims = getAllClaimsFromToken(token);
        return (claims.get("mobile").equals(userDetails.getMobile().toString()) && !isTokenExpired(token));
    }

    //retrieve userId from jwt token
    public String getIdFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
}
