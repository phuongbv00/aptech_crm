package com.aptech.usm.utils;

import dnl.utils.text.table.TextTable;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

public class CliUtil {
    public static <T> void printTable(String[] titles, Collection<T> dataset, Class<T> tClass) {
        var tt = new TextTable(titles, dataset.stream().map(data -> {
            try {
                return getObjectArray(data, tClass);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return new Object[]{};
        }).toArray(Object[][]::new));
        tt.printTable();
    }

    public static <T> void printRecord(String[] titles, T data, Class<T> tClass) {
        try {
            var tt = new TextTable(titles, new Object[][]{getObjectArray(data, tClass)});
            tt.printTable();
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static <T> Object[] getObjectArray(T data, Class<T> tClass) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        var fields = tClass.getDeclaredFields();
        return Arrays.stream(fields)
                .peek(f -> f.setAccessible(true))
                .map(f -> {
                    try {
                        var val = f.get(data);
                        f.setAccessible(false);
                        return val;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return new Object[]{};
                    }
                })
                .toArray();
    }
}
