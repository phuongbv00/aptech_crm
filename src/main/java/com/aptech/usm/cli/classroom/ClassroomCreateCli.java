package com.aptech.usm.cli.classroom;

import com.aptech.usm.cli.Cli;

import java.util.Collections;
import java.util.List;

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

    }
}
