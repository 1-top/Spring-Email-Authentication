package com.harrybro.email.springemailauthentication.user.dto;

import com.harrybro.email.springemailauthentication.user.domain.User;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class UserSignUpRequest {

    @Email
    private String email;

    @NotBlank
    private String authCode;

    public User toEntity() {
        return User.builder()
                .email(email)
                .build();
    }

}
