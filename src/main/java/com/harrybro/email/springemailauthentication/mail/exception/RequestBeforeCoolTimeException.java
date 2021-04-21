package com.harrybro.email.springemailauthentication.mail.exception;

public class RequestBeforeCoolTimeException extends IllegalArgumentException {

    public RequestBeforeCoolTimeException(EmailExceptionMessage m) {
        super(m.getMessage());
    }

}
