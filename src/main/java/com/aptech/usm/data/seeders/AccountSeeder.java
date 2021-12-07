package com.aptech.usm.data.seeders;

import com.aptech.usm.data.repositories.AccountRepository;
import com.aptech.usm.dto.account.AccountCreateDTO;
import com.aptech.usm.services.AccountService;
import com.aptech.usm.utils.BeanUtil;
import com.aptech.usm.utils.enums.AccountRoleEnum;

public class AccountSeeder implements Runnable {
    @Override
    public void run() {
        var accountRepository = BeanUtil.getBean(AccountRepository.class);
        var accountService = BeanUtil.getBean(AccountService.class);
        if (accountRepository.count() > 0)
            return;
        accountService.create(AccountCreateDTO
                .builder()
                .username("admin")
                .password("123456")
                .role(AccountRoleEnum.ADMIN)
                .build());
    }
}
