package com.aptech.usm.cli.account;

import com.aptech.usm.cli.Cli;
import com.aptech.usm.data.domains.Account;
import com.aptech.usm.data.repositories.AccountRepository;
import com.aptech.usm.dto.account.AccountDTO;
import com.aptech.usm.services.AuthService;
import com.aptech.usm.utils.BeanUtil;
import com.aptech.usm.utils.CliUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AccountCli implements Cli {
    @Override
    public String getLabel() {
        return "Tài khoản";
    }

    @Override
    public List<Cli> getSubCli() {
        return List.of(
                new AccountChangePasswordCli()
        );
    }

    @Override
    public void run() {
        if (!BeanUtil.getBean(AuthService.class).isAdmin())
            return;
        var mapper = BeanUtil.getBean(ObjectMapper.class);
        var repo = BeanUtil.getBean(AccountRepository.class);
        var dataset = repo.findAll()
                .stream()
                .map(acc -> mapper.convertValue(acc, AccountDTO.class))
                .collect(Collectors.toList());
        var titles = new String[]{"ID", "Tên tài khoản", "Vai trò"};
        CliUtil.printTable(titles, dataset, AccountDTO.class);
    }
}
