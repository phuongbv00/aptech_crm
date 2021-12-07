package com.aptech.usm.services;

import com.aptech.usm.dto.account.AccountCreateDTO;

public interface AccountService {
    void create(AccountCreateDTO account);

    boolean changePassword(Long accId, String oldPwd, String newPwd);
}
