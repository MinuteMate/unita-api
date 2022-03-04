package com.minutemate.unitaapi.domain.account.email.token;

import com.minutemate.unitaapi.domain.account.email.target.AuthorizeEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtEmailTokenGenerator implements EmailTokenGenerator {
    private AuthorizeJwtTokenizer tokenizer;

    @Override
    public EmailToken of(AuthorizeEmail email) {
        String token = tokenizer.emailToToken(email.getEmail());
        return new EmailToken(token);
    }
}
