package com.aptech.crm.cli.account;

import com.aptech.crm.cli.Cli;
import com.aptech.crm.data.repositories.AccountRepository;
import com.aptech.crm.dto.account.AccountDTO;
import com.aptech.crm.services.AuthService;
import com.aptech.crm.utils.BeanUtil;
import com.aptech.crm.utils.CliUtil;
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
