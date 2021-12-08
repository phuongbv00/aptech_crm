package com.aptech.crm.cli.account;

import com.aptech.crm.cli.Cli;
import com.aptech.crm.data.domains.Account;
import com.aptech.crm.services.AccountService;
import com.aptech.crm.services.AuthService;
import com.aptech.crm.utils.BeanUtil;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AccountChangePasswordCli implements Cli {
    private final AuthService authService = BeanUtil.getBean(AuthService.class);
    private final AccountService accountService = BeanUtil.getBean(AccountService.class);

    @Override
    public String getLabel() {
        return "Đổi mật khẩu";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {
        var scanner = new Scanner(System.in);
        System.out.print("Nhập mật khẩu hiện tại: ");
        var oldPwd = scanner.nextLine();
        System.out.print("Nhập mật khẩu mới: ");
        var newPwd = scanner.nextLine();
        if (accountService.changePassword(authService.getAuth().map(Account::getId).orElse(null), oldPwd, newPwd)) {
            System.out.println("Đổi mật khẩu thành công");
        } else {
            System.out.println("Không thể đổi mật khẩu");
        }
    }
}
