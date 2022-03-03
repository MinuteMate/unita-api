package com.minutemate.unitaapi.domain.account.service;

import com.minutemate.unitaapi.domain.account.data.identifier.number.AuthorizeNumber;
import com.minutemate.unitaapi.domain.account.email.target.AuthorizeEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailAuthorizeService implements AuthorizeService<AuthorizeEmail, AuthorizeNumber> {

    @Override
    public AuthorizeNumber generateIdentifier() {
        return null;
    }

    @Override
    public void addIdentifier(AuthorizeNumber number) {

    }

    @Override
    public AuthorizeEmail getEmailByIdentifier(AuthorizeNumber identifier) {
        return null;
    }
}
