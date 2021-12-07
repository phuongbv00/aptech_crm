package com.aptech.usm.cli.account;

import com.aptech.usm.cli.Cli;

import java.util.Collections;
import java.util.List;

public class AccountCreateCli implements Cli {
    @Override
    public String getLabel() {
        return "Tạo tài khoản";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {

    }
}
