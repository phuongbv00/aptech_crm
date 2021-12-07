package com.aptech.usm.cli.account;

import com.aptech.usm.cli.Cli;

import java.util.List;

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

    }
}
