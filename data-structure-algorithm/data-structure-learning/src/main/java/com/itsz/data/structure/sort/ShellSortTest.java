package com.itsz.data.structure.sort;

public class ShellSortTest {

    public static void main(String[] args) {
        int [] arr = {23,12, 3, -12, 24, 8, 5, 60, 34};

        new ShellSort().sort(arr);

        int [] arr2 = {23,12, 3, -12, 24, 8, 5, 60, 34};

        new ShellSort().sort2(arr2);
    }
}
