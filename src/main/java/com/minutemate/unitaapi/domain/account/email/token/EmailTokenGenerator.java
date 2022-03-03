package com.minutemate.unitaapi.domain.account.email.token;

import com.minutemate.unitaapi.domain.account.email.target.AuthorizeEmail;

public interface EmailTokenGenerator {
    EmailToken of(AuthorizeEmail email);
}
