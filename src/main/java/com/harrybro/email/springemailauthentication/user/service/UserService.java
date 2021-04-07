package com.harrybro.email.springemailauthentication.user.service;

import com.harrybro.email.springemailauthentication.mail.domain.EmailAuthCode;
import com.harrybro.email.springemailauthentication.mail.repository.EmailAuthCodeRepository;
import com.harrybro.email.springemailauthentication.user.dto.UserSignUpRequest;
import com.harrybro.email.springemailauthentication.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final EmailAuthCodeRepository emailAuthCodeRepository;

    public void signup(UserSignUpRequest dto) {
        String email = dto.getEmail();
        EmailAuthCode emailAuthCode = emailAuthCodeRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("이메일 인증 요청을 해주세요."));
        if (emailAuthCode.getAuthCode().equals(dto.getAuthCode()))
            userRepository.save(dto.toEntity());
        else throw new IllegalArgumentException("인증코드가 일치하지 않습니다.");
        emailAuthCodeRepository.delete(emailAuthCode);
    }

}
