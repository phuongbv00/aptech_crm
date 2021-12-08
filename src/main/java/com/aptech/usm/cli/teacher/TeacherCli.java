package com.aptech.usm.cli.teacher;

import com.aptech.usm.cli.Cli;
import com.aptech.usm.data.domains.Teacher;
import com.aptech.usm.data.repositories.TeacherRepository;
import com.aptech.usm.services.AuthService;
import com.aptech.usm.utils.BeanUtil;
import com.aptech.usm.utils.CliUtil;

import java.util.Collections;
import java.util.List;

public class TeacherCli implements Cli {
    private final AuthService auth = BeanUtil.getBean(AuthService.class);

    @Override
    public String getLabel() {
        return "Giảng viên";
    }

    @Override
    public List<Cli> getSubCli() {
        return auth.isAdmin()
                ? List.of(new TeacherCreateCli())
                : Collections.emptyList();
    }

    @Override
    public void run() {
        var repo = BeanUtil.getBean(TeacherRepository.class);
        var dataset = repo.findAll();
        var titles = new String[]{"ID", "Họ tên", "CCCD", "Ngày sinh", "Điện thoại", "Email"};
        CliUtil.printTable(titles, dataset, Teacher.class);
    }
}
