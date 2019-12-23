package com.itsz.data.structure.recurse;

import java.util.Arrays;

/**
 * 递归解决8皇后问题
 * 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法?
 */
public class BaHuangHou {

    private static final int MAX = 8;

    /**
     *  表示第n行的位置：第1个元素的值代表位置为 (0, array[0])
     *
     */

    private static final int[] array = new int[8];


    public static void main(String[] args) {
        check(0);


    }

    public static void check(int n) {
        if (n == MAX) {
            print();
            return;
        }
        for (int i = 0; i < MAX; i++) {
            array[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }



    }

    private static boolean judge(int n) {
        for (int i = 0; i <n ; i++) {
            //表示同一列 或者在对角线上
            if (array[i]==array[n] || Math.abs(i-n)== Math.abs(array[i]-array[n])){
                return false;
            }

        }
        return true;

    }

    private static void print() {
        Arrays.stream(array).forEach(value -> System.out.printf("%d\t\t", value));
        System.out.println();
    }


}
