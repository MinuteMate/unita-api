package com.minutemate.unitaapi.domain.account.email.token;

public class JwtEmailTokenGenerator implements EmailTokenGenerator {
    @Override
    public EmailToken of(String email) {
        String token = ""; //TODO JWT 를 통한 EmailToken 생성로직 작성
        return new EmailToken(token);
    }
}
