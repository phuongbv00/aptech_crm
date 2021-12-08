package com.aptech.crm.cli.student;

import com.aptech.crm.cli.Cli;
import com.aptech.crm.data.domains.Student;
import com.aptech.crm.data.repositories.StudentRepository;
import com.aptech.crm.utils.BeanUtil;
import com.aptech.crm.utils.CliUtil;

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
