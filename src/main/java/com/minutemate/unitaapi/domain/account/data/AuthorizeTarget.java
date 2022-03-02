package com.minutemate.unitaapi.domain.account.data;

public interface AuthorizeTarget {
    //인증용 식별자를 송신한다
    void sendIdentifier(AuthorizeIdentifier identifier);
}
