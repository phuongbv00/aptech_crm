package com.aptech.usm;

import com.aptech.usm.cli.LoginCli;
import com.aptech.usm.data.seeders.BatchSeeder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsmApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UsmApplication.class, args);
    }

    @Override
    public void run(String... args) {
        new BatchSeeder().run();

        System.out.println("Ứng dụng quản lý đăng ký học phần trực tuyến");
        new LoginCli().start();
    }
}
