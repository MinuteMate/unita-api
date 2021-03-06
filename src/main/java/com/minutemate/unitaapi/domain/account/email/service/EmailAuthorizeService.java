package com.minutemate.unitaapi.domain.account.email.service;

import com.minutemate.unitaapi.domain.account.data.identifier.number.AuthorizeNumber;
import com.minutemate.unitaapi.domain.account.data.identifier.number.AuthorizeNumberGenerator;
import com.minutemate.unitaapi.domain.account.email.exception.DuplicateKeyException;
import com.minutemate.unitaapi.domain.account.email.exception.UnknownKeyException;
import com.minutemate.unitaapi.domain.account.email.target.AuthorizeEmail;
import com.minutemate.unitaapi.domain.account.email.target.AuthorizeEmailGenerator;
import com.minutemate.unitaapi.domain.account.entity.AuthorizeNumberEntity;
import com.minutemate.unitaapi.domain.account.repository.AuthorizeNumberRepository;
import com.minutemate.unitaapi.domain.account.service.AuthorizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailAuthorizeService implements AuthorizeService<AuthorizeEmail, AuthorizeNumber> {
    private final AuthorizeNumberRepository authorizeNumberRepository;
    private final AuthorizeNumberGenerator authorizeNumberGenerator;
    private final AuthorizeEmailGenerator authorizeEmailGenerator;

    @Override
    public AuthorizeNumber generateIdentifier() {
        return generateWithoutDuplicate();
    }

    @Override
    public void addIdentifier(AuthorizeNumber number, AuthorizeEmail email) {
        if(authorizeNumberRepository.existsById(number.getIdentifier())) throw new DuplicateKeyException("이미 매핑된 인증번호입니다! 인증번호 : " + number.getIdentifier());
        authorizeNumberRepository.save(new AuthorizeNumberEntity(number.getIdentifier(), email.getEmail()));
    }

    @Override
    public AuthorizeEmail getEmailByIdentifier(AuthorizeNumber number) {
        if(!authorizeNumberRepository.existsById(number.getIdentifier())) throw new UnknownKeyException("알 수 없는 인증번호입니다! 인증번호 : " + number.getIdentifier());
        return authorizeEmailGenerator.of(authorizeNumberRepository.findById(number.getIdentifier()).get().getEmail());
    }

    @Override
    public void deleteIdentifier(AuthorizeNumber number) {
        authorizeNumberRepository.deleteById(number.getIdentifier());
    }

    private AuthorizeNumber generateWithoutDuplicate() {
        AuthorizeNumber number;
        do {
            number = authorizeNumberGenerator.generate();
        } while (authorizeNumberRepository.existsById(number.getIdentifier()));
        return number;
    }
}
