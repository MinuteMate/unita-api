package com.minutemate.unitaapi.domain.account.email.token;

public interface EmailTokenGenerator {
    EmailToken of(String email);
}
