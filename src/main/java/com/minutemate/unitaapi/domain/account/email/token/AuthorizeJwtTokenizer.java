package com.minutemate.unitaapi.domain.account.email.token;

import com.minutemate.unitaapi.domain.account.email.config.AuthorizeJwtProperty;
import com.minutemate.unitaapi.global.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthorizeJwtTokenizer {
    private final AuthorizeJwtProperty authorizeJwtProperty;

    public String emailToToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        return JwtUtil.jwt(authorizeJwtProperty.getSecret(), authorizeJwtProperty.getExpiredSeconds(), claims);
    }

    public String TokenToEmail(String token) {
        return parse(token).get("email", String.class);
    }

    public Claims parse (String token) {
        return JwtUtil.parse(authorizeJwtProperty.getSecret(), token);
    }
}
