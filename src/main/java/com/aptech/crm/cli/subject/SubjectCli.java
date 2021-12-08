package com.aptech.crm.cli.subject;

import com.aptech.crm.cli.Cli;
import com.aptech.crm.data.domains.Subject;
import com.aptech.crm.data.repositories.SubjectRepository;
import com.aptech.crm.services.AuthService;
import com.aptech.crm.utils.BeanUtil;
import com.aptech.crm.utils.CliUtil;

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
