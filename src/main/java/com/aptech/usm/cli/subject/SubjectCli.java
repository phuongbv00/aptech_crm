package com.aptech.usm.cli.subject;

import com.aptech.usm.cli.Cli;

import java.util.Collections;
import java.util.List;

public class SubjectCli implements Cli {
    @Override
    public String getLabel() {
        return "Môn học";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {

    }
}
