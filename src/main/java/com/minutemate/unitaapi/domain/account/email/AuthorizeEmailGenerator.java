package com.minutemate.unitaapi.domain.account.email;

import com.minutemate.unitaapi.domain.account.data.identifier.AuthorizeNumber;
import com.minutemate.unitaapi.domain.account.data.target.AuthorizeTarget;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorizeEmailGenerator {
    private final AuthorizeEmailSender sender;

    public AuthorizeEmail of(String email) {
        return new AuthorizeEmail(email, sender);
    }

    private static record AuthorizeEmail(String email, AuthorizeEmailSender sender) implements AuthorizeTarget<AuthorizeNumber> {
        @Override
        public void sendIdentifier(AuthorizeNumber identifier) {
            sender.send(email, identifier);
        }
    }
}
