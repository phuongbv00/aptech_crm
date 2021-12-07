package com.aptech.usm.cli;

import com.aptech.usm.cli.account.AccountCli;
import com.aptech.usm.services.AuthService;
import com.aptech.usm.utils.BeanUtil;

import java.util.List;
import java.util.Scanner;

public class LoginCli implements Cli {
    @Override
    public String getLabel() {
        return "";
    }

    @Override
    public List<Cli> getSubCli() {
        return List.of(
                new AccountCli()
        );
    }

    @Override
    public void run() {
        if (BeanUtil.getBean(AuthService.class).isAuth())
            return;
        var scanner = new Scanner(System.in);
        System.out.print("Tên đăng nhập: ");
        var username = scanner.nextLine();
        System.out.print("Mật khẩu: ");
        var password = scanner.nextLine();
        var authService = BeanUtil.getBean(AuthService.class);
        if (authService.login(username, password)) {
            System.out.println("Đăng nhập thành công");
        } else {
            System.out.println("Sai tên đăng nhập hoặc mật khẩu");
            System.exit(0);
        }
    }
}
