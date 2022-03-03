package com.minutemate.unitaapi.domain.account.repository;

import com.minutemate.unitaapi.domain.account.email.target.AuthorizeEmail;
import com.minutemate.unitaapi.domain.account.entity.AuthorizeNumberEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorizeNumberRepository extends CrudRepository<AuthorizeNumberEntity, String> {
    boolean existsByAuthorizeNumber(String authorizeNumber);
    AuthorizeEmail getByAuthorizeNumber(String authorizeNumber);
}
