package com.aptech.usm.cli.classroom;

import com.aptech.usm.cli.Cli;

import java.util.Collections;
import java.util.List;

public class ClassroomDetailsCli implements Cli {
    @Override
    public String getLabel() {
        return "Thông tin chi tiết lớp học phần";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {

    }
}
