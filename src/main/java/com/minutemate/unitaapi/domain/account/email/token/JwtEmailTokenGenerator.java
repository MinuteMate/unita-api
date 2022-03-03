package com.minutemate.unitaapi.domain.account.email.token;

import com.minutemate.unitaapi.domain.account.email.target.AuthorizeEmail;
import org.springframework.stereotype.Component;

@Component
public class JwtEmailTokenGenerator implements EmailTokenGenerator {
    @Override
    public EmailToken of(AuthorizeEmail email) {
        String token = "tokenis" + email; //TODO JWT 를 통한 EmailToken 생성로직 작성
        return new EmailToken(token);
    }
}
