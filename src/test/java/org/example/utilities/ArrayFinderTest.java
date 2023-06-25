package org.example.utilities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFinderTest {

    private static final String LENGTH_CONSTRAINT_EXCEPTION_MESSAGE = "Length of each array should be exactly 4";

    @Test
    void findArray_OneArrayHasOneTarget() {
        int target = 4;
        List<Integer[]> arrays = new ArrayList<>(Arrays.asList(
                new Integer[]{1, 2, 1, 2},
                new Integer[]{3, 4, 3, 2}));

        assertTrue(Arrays.deepEquals(
                ArrayFinder.findArray(arrays, target).toArray(),
                new Integer[][]{{3, 4, 3, 2}}));
    }

    @Test
    void findArray_FewArraysHasOneTarget() {
        int target = 4;
        List<Integer[]> arrays = new ArrayList<>(Arrays.asList(
                new Integer[]{1, 4, 1, 2},
                new Integer[]{3, 4, 1, 2}));

        assertTrue(Arrays.deepEquals(
                ArrayFinder.findArray(arrays, target).toArray(),
                new Integer[][]{{1, 4, 1, 2}, {3, 4, 1, 2}}));
    }

    @Test
    void findArray_FewArraysHasFewTargets() {
        int target = 4;
        List<Integer[]> arrays = new ArrayList<>(Arrays.asList(
                new Integer[]{1, 4, 1, 4},
                new Integer[]{3, 4, 1, 4}));

        assertTrue(Arrays.deepEquals(
                ArrayFinder.findArray(arrays, target).toArray(),
                new Integer[][]{{1, 4, 1, 4}, {3, 4, 1, 4}}));
    }

    @Test
    void findArray_NoArraysHasATarget() {
        int target = 2;
        List<Integer[]> arrays = new ArrayList<>(Arrays.asList(
                new Integer[]{1, 4, 1, 4},
                new Integer[]{3, 4, 3, 4}));

        assertTrue(Arrays.deepEquals(
                ArrayFinder.findArray(arrays, target).toArray(),
                new Integer[]{}));
    }

    @Test
    void findArray_ArrayIsBiggerThanLengthConstraint() {
        int target = 2;
        List<Integer[]> arrays = new ArrayList<>(Arrays.asList(
                new Integer[]{1, 4, 1, 4, 5},
                new Integer[]{3, 4, 3, 4}));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> ArrayFinder.findArray(arrays, target));
        assertEquals(exception.getMessage(), LENGTH_CONSTRAINT_EXCEPTION_MESSAGE);
    }

    @Test
    void findArray_ArrayIsSmallerThanLengthConstraint() {
        int target = 2;
        List<Integer[]> arrays = new ArrayList<>(Arrays.asList(
                new Integer[]{1, 4, 1, 4},
                new Integer[]{3, 4, 3}));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> ArrayFinder.findArray(arrays, target));
        assertEquals(exception.getMessage(), LENGTH_CONSTRAINT_EXCEPTION_MESSAGE);
    }
}