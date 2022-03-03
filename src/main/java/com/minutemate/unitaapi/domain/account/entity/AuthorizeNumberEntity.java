package com.minutemate.unitaapi.domain.account.entity;

import com.minutemate.unitaapi.domain.account.email.target.AuthorizeEmail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@RedisHash("authorize-number")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizeNumberEntity {
    @Id
    private String authorizeNumber;
    private AuthorizeEmail email;
}
