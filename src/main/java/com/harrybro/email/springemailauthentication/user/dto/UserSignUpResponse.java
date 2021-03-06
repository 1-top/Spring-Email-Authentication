package com.harrybro.email.springemailauthentication.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignUpResponse {

    private String email;

    private String message;

}
