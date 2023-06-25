package org.example.utilities;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFinderTest {

    private static final String LENGTH_CONSTRAINT_EXCEPTION_MESSAGE = "Length of each array should be exactly 4";

    private static Stream<Arguments> argumentsForPositiveTests() {
        return Stream.of(
                Arguments.of("Case1 : one array has one target.",
                        new ArrayList<>(Arrays.asList(
                                new Integer[]{1, 2, 1, 2},
                                new Integer[]{3, 4, 3, 2})),
                        4,
                        new ArrayList<>(Collections.singletonList(
                                new Integer[]{3, 4, 3, 2}))),
                Arguments.of("Case2 : few arrays have one target each.",
                        new ArrayList<>(Arrays.asList(
                                new Integer[]{1, 4, 1, 2},
                                new Integer[]{3, 4, 1, 2})),
                        4,
                        new ArrayList<>(Arrays.asList(
                                new Integer[]{1, 4, 1, 2},
                                new Integer[]{3, 4, 1, 2}))),
                Arguments.of("Case3 : few arrays have few targets each.",
                        new ArrayList<>(Arrays.asList(
                                new Integer[]{1, 4, 1, 4},
                                new Integer[]{3, 4, 1, 4})),
                        4,
                        new ArrayList<>(Arrays.asList(
                                new Integer[]{1, 4, 1, 4},
                                new Integer[]{3, 4, 1, 4}))),
                Arguments.of("Case4 : no arrays have a target.",
                        new ArrayList<>(Arrays.asList(
                                new Integer[]{1, 4, 1, 4},
                                new Integer[]{3, 4, 1, 4})),
                        2,
                        Collections.EMPTY_LIST)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsForPositiveTests")
    void findArray_PositiveTests(String description, List<Integer[]> arrays, int target, List<Integer[]> expected) {
        assertTrue(Arrays
                .deepEquals(ArrayFinder.findArray(arrays, target).toArray(),
                            expected.toArray()));
    }

    private static Stream<Arguments> argumentsForNegativeTests() {
        return Stream.of(
                Arguments.of("Case1 : an array is bigger than length constraint.",
                        new ArrayList<>(Arrays.asList(
                                new Integer[]{1, 2, 1, 2, 2},
                                new Integer[]{3, 4, 3, 2}))),
                Arguments.of("Case2 : an array is shorter than length constraint.",
                        new ArrayList<>(Arrays.asList(
                                new Integer[]{1, 4, 1, 2},
                                new Integer[]{3, 4, 1})))
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsForNegativeTests")
    void findArray_NegativeTests(String description, List<Integer[]> arrays) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ArrayFinder.findArray(arrays, 0));
        assertEquals(exception.getMessage(), LENGTH_CONSTRAINT_EXCEPTION_MESSAGE);
    }
}