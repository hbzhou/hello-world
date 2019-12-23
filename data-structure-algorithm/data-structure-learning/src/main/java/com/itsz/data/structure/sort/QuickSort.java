package com.itsz.data.structure.sort;

/**
 * 快速排序
 * refer to https://www.cnblogs.com/menglong1108/p/11749616.html
 */
public class QuickSort {

    public void sort(int[] arr, int left, int right) {
        int l, r, temp, flag;

        if (left >= right) {
            return;
        }

        l = left;
        r = right;
        flag = arr[left];

        //右指针大于左指针
        while (r > l) {
            //从右边开始遍历，直到某个值小于 flag
            while (arr[r] >= flag && r > l) {
                r--;
            }
            //从左边开始遍历，直到某个值大于flag
            while (arr[l] <= flag && r > l) {
                l++;
            }

            //交换
            if (r > l) {
                temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }

        }
        arr[left] = arr[l];
        arr[l] = flag;

        //开始递归遍历，左边剩余的部分
        sort(arr,left, l -1);
        sort(arr, l +1, right);
    }
}
