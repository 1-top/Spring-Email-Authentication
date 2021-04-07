package com.harrybro.email.springemailauthentication.mail.repository;

import com.harrybro.email.springemailauthentication.mail.domain.EmailAuthCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailAuthCodeRepository extends JpaRepository<EmailAuthCode, Long> {
    Optional<EmailAuthCode> findByEmail(String email);
}
