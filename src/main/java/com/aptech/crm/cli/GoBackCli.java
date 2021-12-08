package com.aptech.crm.cli;

import com.aptech.crm.utils.CliStack;

import java.util.Collections;
import java.util.List;

public class GoBackCli implements Cli {
    @Override
    public String getLabel() {
        return "Quay lại";
    }

    @Override
    public List<Cli> getSubCli() {
        return Collections.emptyList();
    }

    @Override
    public void run() {
        CliStack.back().ifPresent(Cli::start);
    }
}
