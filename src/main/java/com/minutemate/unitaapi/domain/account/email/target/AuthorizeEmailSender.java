package com.minutemate.unitaapi.domain.account.email.target;

import com.minutemate.unitaapi.domain.account.data.identifier.AuthorizeIdentifier;

public interface AuthorizeEmailSender {
    void send(String email, AuthorizeIdentifier identifier);
}
