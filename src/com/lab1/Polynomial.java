package com.lab1;

public class Polynomial {

    private Node first;
    private int size;

    Polynomial() {
        first = new Node(0, 0, null);
        size = 0;
    }

    void add(int basis, int degree) {
        Node current = first;
        for (int i = 0; i < size; i++) {
            current = current.next;
        }
        current.next = new Node(basis, degree, null);
        size++;
    }

    void set(int basis, int degree, int index) {
        node(index).basis = basis;
        node(index).degree = degree;
    }

    Node node(int index) {
        Node x = first.next;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    void delete(int index) {
        Node x = node(index);
        if (index == 0) {
            first.next = x.next;
            size--;
            return;
        }

        Node prev = node(index - 1);

        prev.next = x.next;
        size--;
    }

    void clear() {
        Node x = first.next;
        while (x != null) {
            Node next = x.next;
            x.next = null;
            x.basis = 0;
            x.degree = 0;
            x = next;
        }
        first = new Node(0,0,null);
        size = 0;
    }

    int size() {
        return size;
    }

    void printList() {
        if (size == 0) return;
        for (int i = 0; i < size; i++)
            System.out.print(node(i).basis + "x ^ " + node(i).degree + " ");
        System.out.println();
    }

    static class Node {
        int basis;
        int degree;
        Node next;

        public Node(int basis, int degree, Node next) {
            this.basis = basis;
            this.degree = degree;
            this.next = next;
        }
    }

}