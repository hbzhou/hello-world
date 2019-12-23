package com.itsz.data.structure.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * reference to https://www.cnblogs.com/menglong1108/p/11707112.html
 */
public class ShellSort {

    /**
     * 交换法
     *
     * @param arr
     */
    public void sort(int[] arr) {
        int temp;
        int count = 1;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i - gap;
                while (j >= 0 && arr[j] > arr[j + gap]) {
                    temp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = temp;
                    j -= gap;
                }
            }
            System.out.println("after shell sorting " + count++ + " time, arr = " + Arrays.toString(arr));
        }

    }

    /**
     * 位移法
     *
     * @param arr
     */
    public void sort2(int[] arr) {
        int count = 1;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            System.out.println("after shell sorting " + count++ + " time, arr = " + Arrays.toString(arr));
        }
    }

}
