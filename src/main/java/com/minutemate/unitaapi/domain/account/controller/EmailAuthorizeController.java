package com.minutemate.unitaapi.domain.account.controller;

import com.minutemate.unitaapi.domain.account.data.identifier.number.AuthorizeNumber;
import com.minutemate.unitaapi.domain.account.data.token.AuthorizeToken;
import com.minutemate.unitaapi.domain.account.email.target.AuthorizeEmail;
import com.minutemate.unitaapi.domain.account.email.token.EmailToken;
import com.minutemate.unitaapi.domain.account.email.token.EmailTokenGenerator;
import com.minutemate.unitaapi.domain.account.service.AuthorizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authorize/email")
@RequiredArgsConstructor
public class EmailAuthorizeController implements AuthorizeController<AuthorizeNumber, AuthorizeEmail, EmailToken>{
    private final AuthorizeService<AuthorizeEmail, AuthorizeNumber> authorizeService;
    private final EmailTokenGenerator emailTokenGenerator;

    @Override @PostMapping
    public ResponseEntity<?> sendAuthorizeNumber(@RequestBody AuthorizeEmail email) {
        AuthorizeNumber number = authorizeService.generateIdentifier();
        email.sendIdentifier(number);
        authorizeService.addIdentifier(number, email);
        return ResponseEntity.ok().build();
    }

    @Override @GetMapping
    public ResponseEntity<AuthorizeToken> getAuthorizeTokenByAuthorizeNumber(@RequestBody AuthorizeNumber number) {
        AuthorizeEmail email = authorizeService.getEmailByIdentifier(number);
        EmailToken token = emailTokenGenerator.of(email);
        return ResponseEntity.ok(token);
    }
}
