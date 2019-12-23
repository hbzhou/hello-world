package com.itsz.data.structure.link;

import lombok.Data;
import lombok.ToString;

import java.util.Stack;


@Data
public class SingleLinkedList {

    private Node head = new Node("head", null);

    public void addLast(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addFirst(Node node) {
        Node temp = head.next;
        head.next = node;
        node.next = temp;
    }

    public void insert(Node node, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index < 0");
        }

        int size = size();
        if (index > size) {
            throw new IllegalArgumentException("index > size");
        }

        if (index == 0) {
            addFirst(node);
            return;
        }

        if (index == size) {
            addLast(node);
            return;
        }
        Node temp = head.next;
        while (index > 1) {
            temp = temp.next;
            index--;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void reverse() {
        Node reverse = new Node(null);
        Node temp = head.next;
        while (temp != null) {
            Node nodeTmp = temp.next;
            temp.next = reverse.next;
            reverse.next = temp;
            temp = nodeTmp;
        }
        head.next = reverse.next;
    }

    public int size() {
        int count = 0;
        Node temp = this.head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void list() {
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

    public Node get(int index) {
        if (head.next == null) {
            return null;
        }
        if (index > size() - 1 || index < 0) {
            throw new IllegalArgumentException("illegal argument index");
        }

        Node temp = head.next;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }

    public void set(int index, Node node) {
        if (index > size() - 1 || index < 0) {
            throw new IllegalArgumentException("illegal argument index");
        }
        Node temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        node.next = temp.next.next;
        temp.next = node;

    }


}


@Data
class Node {

    String name;

    Node next;

    public Node(String name, Node next) {
        this.name = name;
        this.next = next;
    }

    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}
