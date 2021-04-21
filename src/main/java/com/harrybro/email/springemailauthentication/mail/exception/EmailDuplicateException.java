package com.harrybro.email.springemailauthentication.mail.exception;

public class EmailDuplicateException extends IllegalArgumentException {

    public EmailDuplicateException(EmailExceptionMessage m) {
        super(m.getMessage());
    }

}
