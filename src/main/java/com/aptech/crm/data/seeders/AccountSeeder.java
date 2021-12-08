package com.aptech.crm.data.seeders;

import com.aptech.crm.data.repositories.AccountRepository;
import com.aptech.crm.dto.account.AccountCreateDTO;
import com.aptech.crm.services.AccountService;
import com.aptech.crm.utils.BeanUtil;
import com.aptech.crm.utils.enums.AccountRoleEnum;

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
