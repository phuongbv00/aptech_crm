package com.aptech.crm.data.seeders;

import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Transactional
public class BatchSeeder implements Runnable {
    private final Runnable[] seeders = new Runnable[]{
            new AccountSeeder(),
    };

    @Override
    public void run() {
        Arrays.stream(seeders).forEach(Runnable::run);
    }
}
