package com.minutemate.unitaapi.domain.account.repository;

import com.minutemate.unitaapi.domain.account.entity.AuthorizeNumberEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorizeNumberRepository extends CrudRepository<AuthorizeNumberEntity, String> {
    AuthorizeNumberEntity getByAuthorizeNumber(String authorizeNumber);
}
