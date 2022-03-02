package com.minutemate.unitaapi.domain.account.email.target;

import com.minutemate.unitaapi.domain.account.data.identifier.AuthorizeNumber;
import com.minutemate.unitaapi.domain.account.data.target.AuthorizeTarget;
import com.minutemate.unitaapi.domain.account.email.AuthorizeEmailSender;

public class AuthorizeEmail implements AuthorizeTarget<AuthorizeNumber> {
    private final String email;
    private final AuthorizeEmailSender sender;

    protected AuthorizeEmail(String email, AuthorizeEmailSender sender) {
        this.email = email;
        this.sender = sender;
    }

    @Override
    public void sendIdentifier(AuthorizeNumber identifier) {
        sender.send(email, identifier);
    }
}
