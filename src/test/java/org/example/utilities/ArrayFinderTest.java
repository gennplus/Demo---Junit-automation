package org.example.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayFinderTest {

    @Test
    void findArray_OneArrayHasOneTarget() {
        int target = 4;
        List<Integer[]> arrays = new ArrayList<>(Arrays.asList(
                new Integer[]{1, 2, 1, 2},
                new Integer[]{3, 4, 3, 2}));

        Assertions.assertTrue(Arrays.deepEquals(
                ArrayFinder.findArray(arrays, target).toArray(),
                new Integer[][]{{3, 4, 3, 2}}));
    }

    @Test
    void findArray_FewArraysHasOneTarget() {
        int target = 4;
        List<Integer[]> arrays = new ArrayList<>(Arrays.asList(
                new Integer[]{1, 4, 1, 2},
                new Integer[]{3, 4, 1, 2}));

        Assertions.assertTrue(Arrays.deepEquals(
                ArrayFinder.findArray(arrays, target).toArray(),
                new Integer[][]{{1, 4, 1, 2}, {3, 4, 1, 2}}));
    }

    @Test
    void findArray_FewArraysHasFewTargets() {
        int target = 4;
        List<Integer[]> arrays = new ArrayList<>(Arrays.asList(
                new Integer[]{1, 4, 1, 4},
                new Integer[]{3, 4, 1, 4}));

        Assertions.assertTrue(Arrays.deepEquals(
                ArrayFinder.findArray(arrays, target).toArray(),
                new Integer[][]{{1, 4, 1, 4}, {3, 4, 1, 4}}));
    }

    @Test
    void findArray_NoArraysHasATarget() {
        int target = 2;
        List<Integer[]> arrays = new ArrayList<>(Arrays.asList(
                new Integer[]{1, 4, 1, 4},
                new Integer[]{3, 4, 3, 4}));

        Assertions.assertTrue(Arrays.deepEquals(
                ArrayFinder.findArray(arrays, target).toArray(),
                new Integer[]{}));
    }
}