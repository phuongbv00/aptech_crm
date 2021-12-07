package com.aptech.usm.cli.account;

import com.aptech.usm.cli.Cli;

import java.util.Collections;
import java.util.List;

public class AccountCli implements Cli {
    @Override
    public String getLabel() {
        return "Quản lý tài khoản";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {

    }
}
