package com.minutemate.unitaapi.domain.account.controller;

import com.minutemate.unitaapi.domain.account.data.Authorizer;
import com.minutemate.unitaapi.domain.account.data.identifier.number.AuthorizeNumber;
import com.minutemate.unitaapi.domain.account.data.identifier.number.AuthorizeNumberGenerator;
import com.minutemate.unitaapi.domain.account.data.token.AuthorizeToken;
import com.minutemate.unitaapi.domain.account.email.target.AuthorizeEmail;
import com.minutemate.unitaapi.domain.account.email.target.AuthorizeEmailGenerator;
import com.minutemate.unitaapi.domain.account.email.token.EmailToken;
import com.minutemate.unitaapi.domain.account.email.token.EmailTokenGenerator;
import com.minutemate.unitaapi.domain.account.request.SendAuthorizeNumberRequest;
import com.minutemate.unitaapi.domain.account.service.AuthorizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authorize/email")
@RequiredArgsConstructor
public class EmailAuthorizeController implements Authorizer<AuthorizeNumber, AuthorizeEmail, EmailToken> {
    private final AuthorizeService<AuthorizeEmail, AuthorizeNumber> authorizeService;
    private final EmailTokenGenerator emailTokenGenerator;
    private final AuthorizeEmailGenerator authorizeEmailGenerator;
    private final AuthorizeNumberGenerator authorizeNumberGenerator;

    @PostMapping
    public ResponseEntity<?> sendAuthorizeNumber(@RequestBody SendAuthorizeNumberRequest request) {
        return sendAuthorizeNumber(authorizeEmailGenerator.of(request.email()));
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> getAuthorizeToken(@PathVariable Integer number) {
        return getAuthorizeTokenByAuthorizeNumber(authorizeNumberGenerator.of(number));
    }

    @Override
    public ResponseEntity<?> sendAuthorizeNumber(AuthorizeEmail email) {
        AuthorizeNumber number = authorizeService.generateIdentifier();
        email.sendIdentifier(number);
        authorizeService.addIdentifier(number, email);
        return ResponseEntity.ok().build();
    }

    @Override @Transactional
    public ResponseEntity<AuthorizeToken> getAuthorizeTokenByAuthorizeNumber(AuthorizeNumber number) {
        AuthorizeEmail email = authorizeService.getEmailByIdentifier(number);
        authorizeService.deleteIdentifier(number);
        EmailToken token = emailTokenGenerator.of(email);
        return ResponseEntity.ok(token);
    }
}
