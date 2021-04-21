package com.harrybro.email.springemailauthentication.mail.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmailExceptionMessage {

    EMAIL_DUPLICATED_EXCEPTION_MESSAGE("해당 이메일 주소는 이미 회원가입된 이메일 주소입니다."),
    COOL_TIME_EXCEPTION_MESSAGE("3분 후에 다시 시도해주세요.");

    private final String message;

}
