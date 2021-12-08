package com.aptech.crm;

import com.aptech.crm.cli.LoginCli;
import com.aptech.crm.data.seeders.BatchSeeder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }

    @Override
    public void run(String... args) {
        new BatchSeeder().run();

        System.out.println("Ứng dụng quản lý đăng ký lớp học phần");
        new LoginCli().start();
    }
}
