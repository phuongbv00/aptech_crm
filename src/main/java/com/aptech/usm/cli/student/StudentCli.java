package com.aptech.usm.cli.student;

import com.aptech.usm.cli.Cli;
import com.aptech.usm.data.domains.Student;
import com.aptech.usm.data.repositories.StudentRepository;
import com.aptech.usm.utils.BeanUtil;
import com.aptech.usm.utils.CliUtil;

import java.util.List;

public class StudentCli implements Cli {
    @Override
    public String getLabel() {
        return "Sinh viên";
    }

    @Override
    public List<Cli> getSubCli() {
        return List.of(
                new StudentCreateCli()
        );
    }

    @Override
    public void run() {
        var repo = BeanUtil.getBean(StudentRepository.class);
        var dataset = repo.findAll();
        var titles = new String[]{"ID", "Họ tên", "CCCD", "Ngày sinh", "Điện thoại", "Email"};
        CliUtil.printTable(titles, dataset, Student.class);
    }
}
