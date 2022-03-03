package com.minutemate.unitaapi.domain.account.entity;

import com.minutemate.unitaapi.domain.account.email.target.AuthorizeEmail;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@RedisHash("authorize-number")
@Getter @Setter
public class AuthorizeNumberEntity {
    @Id
    private String authorizeNumber;
    private AuthorizeEmail email;
}
