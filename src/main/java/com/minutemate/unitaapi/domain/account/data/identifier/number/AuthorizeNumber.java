package com.minutemate.unitaapi.domain.account.data.identifier.number;

import com.minutemate.unitaapi.domain.account.data.identifier.AuthorizeIdentifier;

public class AuthorizeNumber implements AuthorizeIdentifier {
    private final Integer number;

    protected AuthorizeNumber(Integer number) {
        this.number = number;
    }

    @Override //인증번호를 가져온다
    public String getIdentifier() {
        return String.format("%06d", number);
    }
}
