package com.aptech.crm.cli;

import com.aptech.crm.utils.CliStack;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Cli extends Runnable {
    String getLabel();

    List<Cli> getSubCli();

    default Map<Integer, Cli> getCliOptions() {
        var subCli = getSubCli();
        var map = IntStream.range(1, subCli.size() + 1)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), i -> subCli.get(i - 1)));
        if (CliStack.size() > 2) {
            map.put(0, new GoBackCli());
        }
        return map;
    }

    default void start() {
        if (!(this instanceof GoBackCli)) {
            CliStack.push(this);
            System.out.println("=================================================");
            System.out.println(getLabel());
        }
        run();
        var cliOptions = getCliOptions();
        cliOptions.forEach((k, v) -> System.out.format("%d. %s%n", k, v.getLabel()));
        System.out.print("> ");
        var scanner = new Scanner(System.in);
        var chosen = scanner.nextLine();
        Optional.ofNullable(cliOptions.get(Integer.parseInt(chosen))).ifPresent(Cli::start);
    }
}
