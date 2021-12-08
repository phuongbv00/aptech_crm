package com.aptech.usm.cli.classroom;

import com.aptech.usm.cli.Cli;
import com.aptech.usm.data.domains.Classroom;
import com.aptech.usm.data.domains.Subject;
import com.aptech.usm.data.domains.Teacher;
import com.aptech.usm.data.repositories.ClassroomRepository;
import com.aptech.usm.data.repositories.SubjectRepository;
import com.aptech.usm.data.repositories.TeacherRepository;
import com.aptech.usm.utils.BeanUtil;
import com.aptech.usm.utils.CliUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClassroomCreateCli implements Cli {
    @Override
    public String getLabel() {
        return "Tạo mới lớp học phần";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {
        var scanner = new Scanner(System.in);
        var model = new Classroom();
        System.out.print("Tên học phần: ");
        model.setName(scanner.nextLine());
        System.out.print("Ngày bắt đầu (dd/MM/yyyy): ");
        model.setStartDate(LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.print("Ngày kết thúc (dd/MM/yyyy): ");
        model.setEndDate(LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.print("Phòng học: ");
        model.setAddress(scanner.nextLine());

        var subjects = BeanUtil.getBean(SubjectRepository.class).findAll();
        CliUtil.printTable(new String[]{"ID", "Tên môn", "Số tín chỉ"}, subjects, Subject.class);
        System.out.print("Mã môn học: ");
        model.setSubjectId(Long.parseLong(scanner.nextLine()));

        var teachers = BeanUtil.getBean(TeacherRepository.class).findAll();
        CliUtil.printTable(new String[]{"ID", "Họ tên", "CCCD", "Ngày sinh", "Điện thoại", "Email"}, teachers, Teacher.class);
        System.out.print("Mã giảng viên: ");
        model.setTeacherId(Long.parseLong(scanner.nextLine()));

        var titles = new String[]{"ID", "Tên học phần", "Ngày bắt đầu", "Ngày kết thúc", "Phòng học", "Môn học", "Giảng viên"};
        CliUtil.printRecord(titles, model, Classroom.class);
        System.out.print("Bạn muốn tạo mới lớp học phần với thông tin như trên? (y/n): ");
        if (scanner.nextLine().equals("y")) {
            BeanUtil.getBean(ClassroomRepository.class).save(model);
            System.out.println("Tạo mới lớp học phần thành công");
        }
    }
}
