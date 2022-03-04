package com.minutemate.unitaapi.domain.account.email.target;

import com.minutemate.unitaapi.domain.account.email.config.EmailAuthorizeProperty;
import com.minutemate.unitaapi.domain.account.data.identifier.AuthorizeIdentifier;
import com.minutemate.unitaapi.infra.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class HtmlAuthorizeEmailSender implements AuthorizeEmailSender{
    private final EmailAuthorizeProperty property;
    private final MailSenderService service;

    @Override
    public void send(String email, AuthorizeIdentifier identifier) {
        Map<String, Object> models = new HashMap<>();
        models.put("authorize_identifier", identifier.getIdentifier());
        service.sendHtmlEmail(email, property.getTitle(), property.getTemplatePath(), models);
    }
}
