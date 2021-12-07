package com.aptech.usm.services;

import com.aptech.usm.data.domains.Account;
import com.aptech.usm.data.repositories.AccountRepository;
import com.aptech.usm.dto.AccountDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    public AccountServiceImpl(PasswordEncoder passwordEncoder,
                              AccountRepository accountRepository) {
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
    }

    @Override
    public void create(AccountDTO account) {
        var model = new ObjectMapper().convertValue(account, Account.class);
        model.setPassword(passwordEncoder.encode(model.getPassword()));
        accountRepository.save(model);
    }

    @Override
    public boolean changePassword(Long accId, String oldPwd, String newPwd) {
        var acc = accountRepository.findById(accId)
                .filter(a -> passwordEncoder.matches(oldPwd, a.getPassword()))
                .orElse(null);
        if (acc == null)
            return false;
        acc.setPassword(passwordEncoder.encode(newPwd));
        accountRepository.save(acc);
        return true;
    }
}
