package com.itsz.java.thread.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListCurrentTest {

    public static void main(String[] args) {
      //  List<String> arrayList  = Collections.synchronizedList(new ArrayList<>());
        List<String> arrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i <300 ; i++) {
            new Thread(()->{
                arrayList.add(UUID.randomUUID().toString().substring(1,8));
                System.out.println(arrayList);
            }).start();
        }
    }

    /**
     *
     *
     *
     *
     *
     *
     *
     */
}
