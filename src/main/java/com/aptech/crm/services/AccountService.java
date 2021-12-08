package com.aptech.crm.services;

import com.aptech.crm.dto.account.AccountCreateDTO;

public interface AccountService {
    void create(AccountCreateDTO account);

    boolean changePassword(Long accId, String oldPwd, String newPwd);
}
