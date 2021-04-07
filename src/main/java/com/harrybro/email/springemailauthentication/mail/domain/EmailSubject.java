package com.harrybro.email.springemailauthentication.mail.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EmailSubject {

    EMAIL_AUTH_CODE_REQUEST("[KATI] 회원가입 인증 메일");

    @Getter
    private final String subject;

}
