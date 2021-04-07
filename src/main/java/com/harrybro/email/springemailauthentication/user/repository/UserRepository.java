package com.harrybro.email.springemailauthentication.user.repository;

import com.harrybro.email.springemailauthentication.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
