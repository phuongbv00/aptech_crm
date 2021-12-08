package com.aptech.crm.services;

import com.aptech.crm.data.domains.Account;
import com.aptech.crm.data.repositories.AccountRepository;
import com.aptech.crm.dto.account.AccountCreateDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final ObjectMapper objectMapper;

    public AccountServiceImpl(PasswordEncoder passwordEncoder,
                              AccountRepository accountRepository,
                              ObjectMapper objectMapper) {
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void create(AccountCreateDTO account) {
        var model = objectMapper.convertValue(account, Account.class);
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
