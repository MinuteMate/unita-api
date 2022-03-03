package com.minutemate.unitaapi.domain.account.email.token;

import com.minutemate.unitaapi.domain.account.data.token.AuthorizeToken;

public class EmailToken implements AuthorizeToken {
    private final String token;

    protected EmailToken(String token) {
        this.token = token;
    }

    @Override
    public String getToken() {
        return token;
    }
}
