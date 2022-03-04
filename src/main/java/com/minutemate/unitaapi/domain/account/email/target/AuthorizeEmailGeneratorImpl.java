package com.minutemate.unitaapi.domain.account.email.target;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorizeEmailGeneratorImpl implements AuthorizeEmailGenerator {
    private final AuthorizeEmailSender sender;

    @Override
    public AuthorizeEmail of(String email) {
        return new AuthorizeEmail(email, sender);
    }
}
