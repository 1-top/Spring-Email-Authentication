package com.harrybro.email.springemailauthentication.user.api;

import com.harrybro.email.springemailauthentication.user.dto.UserSignUpRequest;
import com.harrybro.email.springemailauthentication.user.dto.UserSignUpResponse;
import com.harrybro.email.springemailauthentication.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("signup")
    public ResponseEntity<UserSignUpResponse> signup(@Valid @RequestBody UserSignUpRequest userSignUpRequest) {
        userService.signup(userSignUpRequest);
        return ResponseEntity.ok().body(UserSignUpResponse.builder()
                .email(userSignUpRequest.getEmail())
                .message("회원가입이 완료되었습니다.")
                .build());
    }

}
