package com.itsz.data.structure.sparse.array;

import org.junit.Test;

import java.util.Random;

public class SparseArrayTest {

    private SparseArray object = new SparseArray();

    @Test
    public void testPrintOriginalArray() {
        int[][] arr = new int[11][11];
        arr[2][3] = 1;
        arr[3][4] = 2;

        object.printArr(arr);
    }

    @Test
    public void testArray2SparseArray() {
        int[][] arr = new int[11][11];
        arr[2][3] = 1;
        arr[3][4] = 2;

        object.array2SparseArray(arr);
    }

    @Test
    public void testSparseArray2Array() {
        int[][] sparseArray = getSparseArray();
        object.sparseArray2Normal(sparseArray);
    }

    @Test
    public void testSaveSparseArray2Local() {
        int[][] sparseArray = getSparseArray();
        object.saveSparseArr2Local(sparseArray);


    }

    @Test
    public void testReadFromLocal2NormalArray(){
        object.readFromLocal2NormalArray();
    }

    /**
     * @return
     */
    private int[][] getSparseArray() {
        int[][] sparseArray = new int[4][3];
        sparseArray[0][0] = 12;
        sparseArray[0][1] = 5;
        sparseArray[0][2] = 3;


        sparseArray[1][0] = new Random().nextInt(12);
        sparseArray[1][1] = new Random().nextInt(5);
        sparseArray[1][2] = new Random().nextInt(50);


        sparseArray[2][0] = new Random().nextInt(12);
        sparseArray[2][1] = new Random().nextInt(5);
        sparseArray[2][2] = new Random().nextInt(50);


        sparseArray[3][0] = new Random().nextInt(12);
        sparseArray[3][1] = new Random().nextInt(5);
        sparseArray[3][2] = new Random().nextInt(50);

        return sparseArray;
    }
}
