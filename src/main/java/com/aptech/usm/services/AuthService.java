package com.aptech.usm.services;

import com.aptech.usm.data.domains.Account;
import com.aptech.usm.data.repositories.AccountRepository;
import com.aptech.usm.utils.enums.AccountRoleEnum;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    private Account authorizedAccount;

    public AuthService(AccountRepository accountRepository,
                       PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(String username, String password) {
        var acc = accountRepository
                .findByUsername(username)
                .filter(u -> passwordEncoder.matches(password, u.getPassword()))
                .orElse(null);
        if (acc == null)
            return false;
        authorizedAccount = acc;
        return true;
    }

    public boolean isAuth() {
        return authorizedAccount != null;
    }

    public Optional<Account> getAuth() {
        return Optional.ofNullable(authorizedAccount);
    }

    public boolean isAdmin() {
        return getAuth()
                .map(Account::getRole)
                .map(r -> r.equals(AccountRoleEnum.ADMIN))
                .orElse(false);
    }
}
