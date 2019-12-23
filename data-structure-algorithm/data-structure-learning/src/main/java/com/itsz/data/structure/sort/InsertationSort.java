package com.itsz.data.structure.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertationSort {

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i;

            while (index - 1 >= 0 && temp < arr[index - 1]) {
                arr[index] = arr[index - 1];
                index--;
            }
            arr[index] = temp;
            System.out.println("sorting after " + i + " time, arr = " + Arrays.toString(arr));
        }

    }
}
