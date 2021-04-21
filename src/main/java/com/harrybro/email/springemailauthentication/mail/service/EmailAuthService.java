package com.harrybro.email.springemailauthentication.mail.service;

import com.harrybro.email.springemailauthentication.mail.domain.EmailAuthCode;
import com.harrybro.email.springemailauthentication.mail.domain.EmailSubject;
import com.harrybro.email.springemailauthentication.mail.exception.EmailDuplicateException;
import com.harrybro.email.springemailauthentication.mail.exception.EmailExceptionMessage;
import com.harrybro.email.springemailauthentication.mail.repository.EmailAuthCodeRepository;
import com.harrybro.email.springemailauthentication.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EmailAuthService {

    private final UserRepository userRepository;
    private final EmailAuthCodeRepository emailAuthCodeRepository;
    private final EmailUtil emailUtil;

    @Transactional
    public void authCodeSend(String email) {
        userRepository.findByEmail(email).ifPresent(user -> {
            throw new EmailDuplicateException(EmailExceptionMessage.EMAIL_DUPLICATED_EXCEPTION_MESSAGE);
        });
        EmailAuthCodeGenerator generator = new EmailAuthCodeGenerator();
        String authCode = generator.executeGenerate();
        emailAuthCodeRepository.findByEmail(email).ifPresent(EmailAuthCode::checkAuthCodeRequestTime);
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
