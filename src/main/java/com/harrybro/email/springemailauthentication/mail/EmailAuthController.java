package com.harrybro.email.springemailauthentication.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class EmailAuthController {

    private final EmailAuthService emailAuthService;

    @GetMapping("email-auth-code")
    public void emailAuthCodeSend() {
        emailAuthService.authCodeSend();
    }

}
