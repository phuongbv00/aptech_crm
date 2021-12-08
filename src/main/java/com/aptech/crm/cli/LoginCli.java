package com.aptech.crm.cli;

import com.aptech.crm.services.AuthService;
import com.aptech.crm.utils.BeanUtil;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LoginCli implements Cli {
    @Override
    public String getLabel() {
        return "Đăng nhập";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {
        if (BeanUtil.getBean(AuthService.class).isAuth()) {
            new AppCli().start();
            return;
        }
        var scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Tên đăng nhập: ");
            var username = scanner.nextLine();
            System.out.print("Mật khẩu: ");
            var password = scanner.nextLine();
            var authService = BeanUtil.getBean(AuthService.class);
            if (authService.login(username, password)) {
                System.out.println("Đăng nhập thành công");
                new AppCli().start();
                return;
            } else {
                System.out.println("Sai tên đăng nhập hoặc mật khẩu");
            }
        }
    }
}
