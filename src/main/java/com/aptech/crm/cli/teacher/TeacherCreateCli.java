package com.aptech.crm.cli.teacher;

import com.aptech.crm.cli.Cli;
import com.aptech.crm.data.domains.Teacher;
import com.aptech.crm.data.repositories.TeacherRepository;
import com.aptech.crm.utils.BeanUtil;
import com.aptech.crm.utils.CliUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TeacherCreateCli implements Cli {
    @Override
    public String getLabel() {
        return "Thêm mới giảng viên";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {
        var scanner = new Scanner(System.in);
        var model = new Teacher();
        System.out.print("Tên giảng viên: ");
        model.setFullName(scanner.nextLine());
        System.out.print("CCCD: ");
        model.setIdentityCard(scanner.nextLine());
        System.out.print("Ngày sinh (dd/MM/yyyy): ");
        model.setBirthday(LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.print("SDT: ");
        model.setPhone(scanner.nextLine());
        System.out.print("Email: ");
        model.setEmail(scanner.nextLine());

        var titles = new String[]{"ID", "Họ tên", "CCCD", "Ngày sinh", "Điện thoại", "Email"};
        CliUtil.printRecord(titles, model, Teacher.class);
        System.out.print("Bạn muốn thêm giảng viên vào hệ thống? (y/n): ");
        if (scanner.nextLine().equals("y")) {
            BeanUtil.getBean(TeacherRepository.class).save(model);
            System.out.println("Thêm giảng viên thành công");
        }
    }
}
