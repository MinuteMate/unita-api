package com.minutemate.unitaapi.domain.account.data;

import com.minutemate.unitaapi.domain.account.data.identifier.AuthorizeIdentifier;
import com.minutemate.unitaapi.domain.account.data.target.AuthorizeTarget;
import com.minutemate.unitaapi.domain.account.data.token.AuthorizeToken;
import org.springframework.http.ResponseEntity;

public interface Authorizer<ID extends AuthorizeIdentifier, TARGET extends AuthorizeTarget<ID>, TOKEN extends AuthorizeToken> {
    //인증할 대상(이메일)을 받아서, 해당 대상에게 인증용 식별자를 송신한다
    //이후, 전송한 인증용식별자를 인증 대상과 매핑하여 저장한다.
    ResponseEntity<?> sendAuthorizeNumber(TARGET request);

    //인증용 식별자를 받아서 인증과정을 거친 후 인증결과를 송신한다.
    //인증과정은 다음과 같다
    //인증용 식별자와 매핑된 인증 대상을 검색한다.
    //매핑된 인증 대상이 있다면 해당 인증 대상에 대한 소유권을 증명하는 인증토큰을 발급한다
    //매핑된 인증 대상이 없다면 에러를 반환한다.
    ResponseEntity<AuthorizeToken> getAuthorizeTokenByAuthorizeNumber(ID identifier);
}
