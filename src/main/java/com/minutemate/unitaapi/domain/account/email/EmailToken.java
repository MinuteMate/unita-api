package com.minutemate.unitaapi.domain.account.email;

import com.minutemate.unitaapi.domain.account.data.token.AuthorizeToken;

public record EmailToken (String token) implements AuthorizeToken {
    @Override
    public String getToken() {
        return token;
    }
}
