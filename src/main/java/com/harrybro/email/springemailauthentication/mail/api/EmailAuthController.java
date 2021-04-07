package com.harrybro.email.springemailauthentication.mail.api;

import com.harrybro.email.springemailauthentication.mail.dto.EmailAuthCodeRequest;
import com.harrybro.email.springemailauthentication.mail.dto.EmailAuthCodeResponse;
import com.harrybro.email.springemailauthentication.mail.service.EmailAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class EmailAuthController {

    private final EmailAuthService emailAuthService;

    @PostMapping("email-auth-code")
    public ResponseEntity<EmailAuthCodeResponse> emailAuthCodeSend(@Valid @RequestBody EmailAuthCodeRequest dto) {
        emailAuthService.authCodeSend(dto.getEmail());
        return ResponseEntity.ok().body(EmailAuthCodeResponse.builder()
                .email(dto.getEmail())
                .message("해당 메일 주소로 인증 번호를 전송했습니다.")
                .build());
    }

}
