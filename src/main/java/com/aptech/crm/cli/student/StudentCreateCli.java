package com.aptech.crm.cli.student;

import com.aptech.crm.cli.Cli;
import com.aptech.crm.dto.student.StudentCreateDTO;
import com.aptech.crm.services.StudentService;
import com.aptech.crm.utils.BeanUtil;
import com.aptech.crm.utils.CliUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentCreateCli implements Cli {
    @Override
    public String getLabel() {
        return "Tạo mới tài khoản sinh viên";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {
        var scanner = new Scanner(System.in);
        var model = new StudentCreateDTO();
        System.out.print("Tên tài khoản đăng nhập của sinh viên: ");
        model.setUsername(scanner.nextLine());
        System.out.print("Mật khẩu đăng nhập của sinh viên: ");
        model.setPassword(scanner.nextLine());
        System.out.print("Tên sinh viên: ");
        model.setFullName(scanner.nextLine());
        System.out.print("CCCD: ");
        model.setIdentityCard(scanner.nextLine());
        System.out.print("Ngày sinh (dd/MM/yyyy): ");
        model.setBirthday(LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.print("SDT: ");
        model.setPhone(scanner.nextLine());
        System.out.print("Email: ");
        model.setEmail(scanner.nextLine());

        var titles = new String[]{"Tên tài khoản", "Mật khẩu", "Họ tên", "CCCD", "Ngày sinh", "Điện thoại", "Email"};
        CliUtil.printRecord(titles, model, StudentCreateDTO.class);
        System.out.print("Bạn muốn tạo tài khoản sinh viên với thông tin trên? (y/n): ");
        if (scanner.nextLine().equals("y")) {
            BeanUtil.getBean(StudentService.class).create(model);
            System.out.println("Tạo mới tài khoản sinh viên thành công");
        }
    }
}
