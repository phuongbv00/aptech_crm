package com.aptech.usm.services;

import com.aptech.usm.data.repositories.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AccountRepository accountRepository,
                       PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(String username, String password) {
        return accountRepository
                .findByUsername(username)
                .map(u -> passwordEncoder.matches(password, u.getPassword()))
                .orElse(false);
    }
}
