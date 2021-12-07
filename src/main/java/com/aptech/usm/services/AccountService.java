package com.aptech.usm.services;

import com.aptech.usm.dto.AccountDTO;

public interface AccountService {
    void create(AccountDTO account);

    boolean changePassword(Long accId, String oldPwd, String newPwd);
}
