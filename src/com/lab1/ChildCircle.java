package com.lab1;

public class ChildCircle {

    private Node start;
    private int size;

    ChildCircle(int children) {
        start = new Node(0, null);
        size = 0;
        for (int i = 1; i <= children; i++)
            this.add(i);
    }

    void add(int e) {
        if (size == 0) {
            start.next = new Node(e,null);
            size++;
            return;
        }
        Node last = node(size - 1);
        last.next = new Node(e, start.next);
        size++;
    }

    int get(int index) {
        return node(index).e;
    }

    Node node(int index) {
        Node x = start.next;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    void delete(int index) {
        Node x = node(index);
        Node next = x.next;

        if (index == 0) {
            Node last = node(size - 1);
            last.next = start.next.next;
            start.next = start.next.next;
            return;
        }

        if (size == 1) {
            start.next = null;
            return;
        }

        Node prev = node(index - 1);
        prev.next = next;
        size--;
    }

    void clear() {
        Node x = start.next;
        for (int i = 0; i < size; i++) {
            Node next = x.next;
            x.next = null;
            x.e = 0;
            x = next;
        }
        start = new Node(0, null);
        size = 0;
    }

    int size() {
        return size;
    }

    int indexOf(int e) {
        Node x = start.next;
        for (int i = 0; i < size; i++) {
            if (e == x.e) return i;
            x = x.next;
        }
        return -1;
    }

    void printList() {
        if (size == 0) return;
        for (int i = 0; i < size; i++)
            System.out.print(node(i).e + " ");
        System.out.println();
    }

    static class Node {
        int e;
        Node next;

        public Node(int e, Node next) {
            this.e = e;
            this.next = next;
        }
    }
}