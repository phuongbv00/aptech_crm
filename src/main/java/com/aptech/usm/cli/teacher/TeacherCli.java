package com.aptech.usm.cli.teacher;

import com.aptech.usm.cli.Cli;

import java.util.Collections;
import java.util.List;

public class TeacherCli implements Cli {
    @Override
    public String getLabel() {
        return "Giảng viên";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {

    }
}
