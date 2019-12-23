package com.itsz.data.structure.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度： O(n2) 平方阶
 */
public class SelectSort {


    public void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("sorting after " + (i + 1) + " time, arr = " + Arrays.toString(arr));
        }

    }
}
