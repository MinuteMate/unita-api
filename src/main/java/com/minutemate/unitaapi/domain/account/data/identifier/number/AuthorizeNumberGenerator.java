package com.minutemate.unitaapi.domain.account.data.identifier.number;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AuthorizeNumberGenerator {
    public AuthorizeNumber generate() {
        Random random = new Random();
        return new AuthorizeNumber(random.nextInt(100000));
    }

    public AuthorizeNumber of(Integer number) {
        return new AuthorizeNumber(number);
    }
}
