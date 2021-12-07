package com.aptech.usm.cli.classroom;

import com.aptech.usm.cli.Cli;

import java.util.List;

public class ClassroomCli implements Cli {
    @Override
    public String getLabel() {
        return "Lớp học";
    }

    @Override
    public List<Cli> getSubCli() {
        return List.of(
                new ClassRegistrationCli()
        );
    }

    @Override
    public void run() {

    }
}
