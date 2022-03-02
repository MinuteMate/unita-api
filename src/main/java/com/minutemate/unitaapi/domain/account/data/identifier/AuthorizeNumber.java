package com.minutemate.unitaapi.domain.account.data.identifier;

public record AuthorizeNumber (Integer number) implements AuthorizeIdentifier  {
    @Override //인증번호를 가져온다
    public String getIdentifier() {
        return String.valueOf(number);
    }
}
