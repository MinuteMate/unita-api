package com.minutemate.unitaapi.domain.account.email;

import com.minutemate.unitaapi.domain.account.data.identifier.AuthorizeIdentifier;

public interface AuthorizeEmailSender {
    void send(String email, AuthorizeIdentifier identifier);
}
