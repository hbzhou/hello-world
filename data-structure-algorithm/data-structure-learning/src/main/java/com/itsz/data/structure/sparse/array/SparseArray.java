package com.itsz.data.structure.sparse.array;


import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 稀疏数组:
 *
 *  棋盘，读取文件
 */
public class SparseArray {

    public void printArr(int[][] arr) {
        for (int[] intElements : arr) {
            Arrays.stream(intElements).forEach(value -> {
                System.out.printf("%d\t", value);
            });
            System.out.println();
        }
    }

    public void array2SparseArray(int[][] arr) {

        printArr(arr);

        System.out.println("=================================");

        //获取非零元素的个数
        int sum = 0;
        for (int[] intElements : arr) {
            sum = (int) (sum + Arrays.stream(intElements).filter(value -> value != 0).count());
        }

        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = arr.length;
        sparseArray[0][1] = arr[0].length;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    ++count;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = arr[i][j];
                }
            }
        }

        printArr(sparseArray);

    }

    public void sparseArray2Normal(int[][] sparseArr) {
        printArr(sparseArr);

        System.out.println("==========================");

        int[][] arr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        printArr(arr);

    }

    public void saveSparseArr2Local(int[][] sparseArr) {
        try {
            final FileWriter writer = new FileWriter(new File("array.txt"));
            for (int[] ints : sparseArr) {
                Arrays.stream(ints).forEach(c -> {
                    try {
                        writer.write(c + "\t");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.write("\r\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    public void readFromLocal2NormalArray() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        int length = 0;

        try {
            fileReader = new FileReader(new File("array.txt"));
            bufferedReader = new BufferedReader(fileReader);
            Stream<String> lines = bufferedReader.lines();
            List<String> strList = lines.collect(Collectors.toList());
            int[][] sparseArray = new int[strList.size()][3];
            for (int i = 0; i < strList.size(); i++) {
                String[] split = strList.get(i).split("\t");
                sparseArray[i][0] = Integer.valueOf(split[0]);
                sparseArray[i][1] = Integer.valueOf(split[1]);
                sparseArray[i][2] = Integer.valueOf(split[2]);
            }
            sparseArray2Normal(sparseArray);
        } catch (IOException e) {

        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {


                }
            }
        }

    }


}
