package com.aptech.usm.cli;

import com.aptech.usm.cli.account.AccountCli;

import java.util.List;

public class AppCli implements Cli {
    @Override
    public String getLabel() {
        return "MAIN MENU";
    }

    @Override
    public List<Cli> getSubCli() {
        return List.of(
                new AccountCli()
        );
    }

    @Override
    public void run() {

    }
}
