package com.aptech.usm.cli.subject;

import com.aptech.usm.cli.Cli;
import com.aptech.usm.data.domains.Subject;
import com.aptech.usm.data.repositories.SubjectRepository;
import com.aptech.usm.services.AuthService;
import com.aptech.usm.utils.BeanUtil;
import com.aptech.usm.utils.CliUtil;

import java.util.Collections;
import java.util.List;

public class SubjectCli implements Cli {
    private final AuthService auth = BeanUtil.getBean(AuthService.class);

    @Override
    public String getLabel() {
        return "Môn học";
    }

    @Override
    public List<Cli> getSubCli() {
        return auth.isAdmin()
                ? List.of(new SubjectCreateCli())
                : Collections.emptyList();
    }

    @Override
    public void run() {
        var repo = BeanUtil.getBean(SubjectRepository.class);
        var dataset = repo.findAll();
        var titles = new String[]{"ID", "Tên môn", "Số tín chỉ"};
        CliUtil.printTable(titles, dataset, Subject.class);
    }
}
