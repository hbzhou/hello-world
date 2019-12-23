package com.itsz.data.structure.sort;

import java.util.Arrays;

public class MergeSortTest {

        public static void main(String[] args) {
        int[] arr = {23, 12, 3, -12, 24, 8, 5, 60, 34};
        new MergeSort().sort(arr,0, arr.length-1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }
}
