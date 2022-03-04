package com.minutemate.unitaapi.domain.account.data.target;

import com.minutemate.unitaapi.domain.account.data.identifier.AuthorizeIdentifier;

public interface AuthorizeTarget <T extends AuthorizeIdentifier> {
    //인증용 식별자를 송신한다
    void sendIdentifier(T identifier);
}
