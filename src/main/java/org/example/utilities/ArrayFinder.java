package org.example.utilities;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayFinder {

    public static List<Integer[]> findArray(List<Integer[]> arrays, Integer numberToFind) {
        return arrays.stream()
                .filter(array -> Arrays.stream(array)
                        .anyMatch(integer -> integer.equals(numberToFind)))
                .collect(Collectors.toList());
    }
}
