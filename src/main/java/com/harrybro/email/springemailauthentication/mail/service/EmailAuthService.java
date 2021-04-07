package com.harrybro.email.springemailauthentication.mail.service;

import com.harrybro.email.springemailauthentication.mail.domain.EmailAuthCode;
import com.harrybro.email.springemailauthentication.mail.domain.EmailSubject;
import com.harrybro.email.springemailauthentication.mail.repository.EmailAuthCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EmailAuthService {

    private final EmailUtil emailUtil;
    private final EmailAuthCodeRepository emailAuthCodeRepository;

    @Transactional
    public void authCodeSend(String email) {
        EmailAuthCodeGenerator generator = new EmailAuthCodeGenerator();
        String authCode = generator.executeGenerate();
        EmailAuthCode emailAuthCode = emailAuthCodeRepository.findByEmail(email)
                .orElseGet(() -> {
                    return emailAuthCodeRepository.save(EmailAuthCode.builder()
                            .email(email)
                            .build());
                });
        emailAuthCode.setAuthCode(authCode);
        emailUtil.sendEmail(email, EmailSubject.EMAIL_AUTH_CODE_REQUEST, authCode);
    }

}
