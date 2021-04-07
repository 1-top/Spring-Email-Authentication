package com.harrybro.email.springemailauthentication.mail.service;

import com.harrybro.email.springemailauthentication.mail.domain.EmailSubject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@RequiredArgsConstructor
@Service
public class EmailAuthService {

    private final EmailUtil emailUtil;

    public void authCodeSend(String email) {
        EmailAuthCodeGenerator generator = new EmailAuthCodeGenerator();
        String authCode = generator.executeGenerate();
        emailUtil.sendEmail(email, EmailSubject.EMAIL_AUTH_CODE_REQUEST, authCode);
    }

}
