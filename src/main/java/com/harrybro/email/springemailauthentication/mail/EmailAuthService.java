package com.harrybro.email.springemailauthentication.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailAuthService {

    private final EmailUtil emailUtil;

    public void authCodeSend() {
        String msg = "test";
        emailUtil.sendEmail("sh_l96@naver.com", "회원가입 인증메일", "test");
    }

}
