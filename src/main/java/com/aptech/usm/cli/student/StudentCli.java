package com.aptech.usm.cli.student;

import com.aptech.usm.cli.Cli;

import java.util.Collections;
import java.util.List;

public class StudentCli implements Cli {
    @Override
    public String getLabel() {
        return "Sinh viên";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {

    }
}
