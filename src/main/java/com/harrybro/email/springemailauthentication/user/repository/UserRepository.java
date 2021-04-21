package com.harrybro.email.springemailauthentication.user.repository;

import com.harrybro.email.springemailauthentication.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
