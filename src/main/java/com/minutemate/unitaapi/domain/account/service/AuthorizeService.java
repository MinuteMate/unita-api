package com.minutemate.unitaapi.domain.account.service;


import com.minutemate.unitaapi.domain.account.data.identifier.AuthorizeIdentifier;
import com.minutemate.unitaapi.domain.account.data.target.AuthorizeTarget;

public interface AuthorizeService<T extends AuthorizeTarget, ID extends AuthorizeIdentifier> {
    ID generateIdentifier();

    void addIdentifier(ID identifier, T target);

    T getEmailByIdentifier(ID identifier);
}
