package org.example.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayFinder {

    private final static int ARRAY_LENGTH = 4;
    private static final String LENGTH_CONSTRAINT_EXCEPTION_MESSAGE = "Length of each array should be exactly 4";

    public static List<Integer[]> findArray(List<Integer[]> arrays, Integer numberToFind) {
        throwExceptionIfArraysHaveIncorrectLength(arrays);

        return arrays.stream()
                .filter(array -> Arrays.stream(array)
                        .anyMatch(integer -> integer.equals(numberToFind)))
                .collect(Collectors.toList());
    }

    private static void throwExceptionIfArraysHaveIncorrectLength(List<Integer[]> arrays) {
        if (arrays.stream().anyMatch(a -> a.length != ARRAY_LENGTH)) {
            throw new IllegalArgumentException(LENGTH_CONSTRAINT_EXCEPTION_MESSAGE);
        }
    }
}
