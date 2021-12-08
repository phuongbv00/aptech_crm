package com.aptech.usm.cli.classroom;

import com.aptech.usm.cli.Cli;

import java.util.Collections;
import java.util.List;

public class ClassLeaveCli implements Cli {
    @Override
    public String getLabel() {
        return "Hủy đăng ký lớp";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {

    }
}
