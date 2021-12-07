package com.aptech.usm.utils;

import com.aptech.usm.cli.Cli;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class CliStack {
    private static final Deque<Cli> stack = new ArrayDeque<>();

    public static int size() {
        return stack.size();
    }

    public static Optional<Cli> back() {
        stack.pollFirst();
        return Optional.ofNullable(stack.pollFirst());
    }

    public static void push(Cli cli) {
        stack.addFirst(cli);
    }
}
