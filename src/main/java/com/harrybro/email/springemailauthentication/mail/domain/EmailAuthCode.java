package com.harrybro.email.springemailauthentication.mail.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Entity
public class EmailAuthCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(unique = true)
    private String email;

    @Getter
    @Setter
    private String authCode;

    @UpdateTimestamp
    private Timestamp updatedDate;

    @Builder
    public EmailAuthCode(String email, String authCode) {
        this.email = email;
        this.authCode = authCode;
    }

}
