package com.itsz.data.structure.link;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class SingleLinkedListTest {

    @Test
    public void testAddList() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addLast(new Node("jeremy"));
        linkedList.addLast(new Node("jason"));
        linkedList.list();
    }


    @Test
    public void testAddFirst() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addFirst(new Node("jeremy"));
        linkedList.addFirst(new Node("jason"));
        linkedList.addFirst(new Node("Shiny"));
        linkedList.list();
    }


    @Test
    public void testInsert() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addLast(new Node("jeremy"));
        linkedList.addLast(new Node("jason"));
        linkedList.addLast(new Node("shiny"));
        linkedList.insert(new Node("Sunny"), 2);
        linkedList.list();
    }

    @Test
    public void testInsertMax() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addLast(new Node("jeremy"));
        linkedList.addLast(new Node("jason"));
        linkedList.addLast(new Node("shiny"));
        linkedList.insert(new Node("Sunny"), 3);
        linkedList.list();
    }

    @Test
    public void testReverse() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addLast(new Node("jeremy"));
        linkedList.addLast(new Node("jason"));
        linkedList.addLast(new Node("shiny"));
        linkedList.addLast(new Node("Sunny"));

        linkedList.reverse();
        linkedList.list();
    }

    @Test
    public void testGet(){
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addLast(new Node("jeremy"));
        linkedList.addLast(new Node("jason"));
        linkedList.addLast(new Node("shiny"));
        linkedList.addLast(new Node("Sunny"));

        System.out.println(linkedList.get(2));
    }

    @Test
    public void testSet(){
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addLast(new Node("jeremy"));
        linkedList.addLast(new Node("jason"));
        linkedList.addLast(new Node("shiny"));
        linkedList.addLast(new Node("Sunny"));
        linkedList.set(2, new Node("Harry"));
        linkedList.list();
    }

}
