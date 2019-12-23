package com.itsz.data.structure.sort;

/**
 * 合并排序
 * refer to https://www.cnblogs.com/menglong1108/p/11787695.html
 */
public class MergeSort {

    /**
     * 递归回溯算法
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public void sort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(arr, left, mid, temp);
        sort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        //temp中的原始下标
        int t = 0;

        while (i <= mid && j <= right) {
            //两边数组都没有比较完 继续
            if (arr[i] < arr[j]) {
                //左边数组中值更小
                temp[t] = arr[i];
                i++;
            } else {
                //右边数组中值更小
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        //有一边已经全部复制到temp中了
        if (i <= mid) {
            //左边还没有复制完，将左边全部元素复制到temp中
            while (i <= mid) {
                temp[t] = arr[i];
                i++;
                t++;
            }
        } else if (j <= right) {
            //右边还没有复制完，将右边全部元素复制到temp中
            while (j <= right) {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //将temp复制到原arr中
        t = 0;
        while (left <= right) {
            arr[left] = temp[t];
            left++;
            t++;
        }

    }
}
