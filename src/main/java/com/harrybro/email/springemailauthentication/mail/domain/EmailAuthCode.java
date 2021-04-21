package com.harrybro.email.springemailauthentication.mail.domain;

import com.harrybro.email.springemailauthentication.mail.exception.EmailExceptionMessage;
import com.harrybro.email.springemailauthentication.mail.exception.RequestBeforeCoolTimeException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    @CreationTimestamp
    private Timestamp createDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    @Builder
    public EmailAuthCode(String email, String authCode) {
        this.email = email;
        this.authCode = authCode;
    }

    public void checkAuthCodeRequestTime() {
        Timestamp coolTime = Timestamp.valueOf(this.updatedDate.toLocalDateTime().plusMinutes(3));
        if (coolTime.after(Timestamp.valueOf(LocalDateTime.now())))
            throw new RequestBeforeCoolTimeException(EmailExceptionMessage.COOL_TIME_EXCEPTION_MESSAGE);
    }

}
