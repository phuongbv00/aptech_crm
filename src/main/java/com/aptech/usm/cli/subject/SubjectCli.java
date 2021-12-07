package com.aptech.usm.cli.subject;

import com.aptech.usm.cli.Cli;
import com.aptech.usm.data.domains.Subject;
import com.aptech.usm.data.repositories.SubjectRepository;
import com.aptech.usm.utils.BeanUtil;
import com.aptech.usm.utils.CliUtil;

import java.util.List;

public class SubjectCli implements Cli {
    @Override
    public String getLabel() {
        return "Môn học";
    }

    @Override
    public List<Cli> getSubCli() {
        return List.of(
                new SubjectCreateCli()
        );
    }

    @Override
    public void run() {
        var repo = BeanUtil.getBean(SubjectRepository.class);
        var dataset = repo.findAll();
        var titles = new String[]{"ID", "Tên môn", "Số tín chỉ"};
        CliUtil.printTable(titles, dataset, Subject.class);
    }
}
