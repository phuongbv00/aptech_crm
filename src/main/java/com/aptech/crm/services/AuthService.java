package com.aptech.crm.services;

import com.aptech.crm.data.domains.Account;
import com.aptech.crm.data.domains.Student;
import com.aptech.crm.data.repositories.AccountRepository;
import com.aptech.crm.data.repositories.StudentRepository;
import com.aptech.crm.utils.enums.AccountRoleEnum;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final StudentRepository studentRepository;

    private Account authorizedAccount;
    private Student authorizedStudent;

    public AuthService(AccountRepository accountRepository,
                       PasswordEncoder passwordEncoder,
                       StudentRepository studentRepository) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.studentRepository = studentRepository;
    }

    public boolean login(String username, String password) {
        var acc = accountRepository
                .findByUsername(username)
                .filter(u -> passwordEncoder.matches(password, u.getPassword()))
                .orElse(null);
        if (acc == null)
            return false;
        authorizedAccount = acc;
        studentRepository.findByAccountId(acc.getId())
                .ifPresent(std -> authorizedStudent = std);
        return true;
    }

    public boolean isAuth() {
        return authorizedAccount != null;
    }

    public Optional<Account> getAuth() {
        return Optional.ofNullable(authorizedAccount);
    }

    public Optional<Student> getAuthStd() {
        return Optional.ofNullable(authorizedStudent);
    }

    public boolean isAdmin() {
        return getAuth()
                .map(Account::getRole)
                .map(r -> r.equals(AccountRoleEnum.ADMIN))
                .orElse(false);
    }
}
