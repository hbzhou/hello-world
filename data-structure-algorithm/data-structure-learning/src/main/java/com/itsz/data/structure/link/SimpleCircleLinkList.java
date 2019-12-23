package com.itsz.data.structure.link;

import lombok.Data;

public class SimpleCircleLinkList {

    private Node first = null;

    private int size;

    public SimpleCircleLinkList(int num) {
        if (num <= 1) {
            throw new IllegalArgumentException("illegal Argument num");
        }
        Node temp = null;
        for (int i = 1; i <= num; i++) {
            Node node = new Node(i);
            if (i == 1) {
                first = node;
                first.next = first;
                temp = first;
            } else {
                temp.next = node;
                node.next = first;
                temp = node;
            }

        }
        this.size = num;
    }

    public void list() {
        if (first == null) {
            return;
        }
        Node temp = first;
        while (true) {
            System.out.println(temp);
            if (temp.next == first) {
                break;
            }
            temp = temp.next;
        }
    }

    public void joseph(int statNo, int step) {
        if (first == null || statNo > size) {
            return;
        }

        Node temp = first;
        while (temp.next != first) {
            temp = temp.next;
        }

        //从0<k<size-1开始
        for (int i = 0; i < statNo; i++) {
            first = first.next;
            temp = temp.next;
        }

        while (temp != first) {
            //报数n
            for (int i = 0; i < step - 1; i++) {
                first = first.next;
                temp = temp.next;
            }
            //出列
            System.out.println(first);
            first = first.next;
            temp.next = first;
        }
        //打印最后一个元素
        System.out.println(first);

    }


    @Data
    class Node {

        int no;

        Node next;


        public Node(int no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    '}';
        }
    }

}
