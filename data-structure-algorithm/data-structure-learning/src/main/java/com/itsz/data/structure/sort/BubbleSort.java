package com.itsz.data.structure.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 冒泡排序
     *  时间复杂度： O(n^2) 平方阶
     * @param arr
     */
    public void sort(int... arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
            System.out.println("after sorting " + (i + 1) + " time, arr =  " + Arrays.toString(arr));
        }

    }
}
