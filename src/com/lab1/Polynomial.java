package com.lab1;

public class Polynomial {

    private final Node first;
    private int size;

    Polynomial() {
        first = new Node(0, 0, null);
        size = 0;
    }

    Polynomial(String polynomialString) {
        first = new Node(0, 0, null);
        size = 0;
        fillPolynomial(getMembersArray(polynomialString));
    }

    private String[] getMembersArray(String polyString) {
        StringBuilder members = new StringBuilder();
        int offset = 0;
        for (int i = 1; i < polyString.length(); i++) {
            if (polyString.charAt(i) == '+') {
                members.append(polyString, offset, i).append("|");
                offset = i + 1;
            } else if (polyString.charAt(i) == '-') {
                members.append(polyString, offset, i).append("|");
                offset = i;
            } else if (i == polyString.length() - 1) {
                members.append(polyString, offset, i + 1);
            }
        }
        return members.toString().split("\\|");
    }

    private void fillPolynomial(String[] members) {
        for (String member : members) {
            String[] memParts = member.split("\\^");
            String coefficient = memParts[0];
            if (coefficient.equals("0x") || coefficient.equals("0")) continue;
            int exponent;

            if (memParts.length != 1) {
                exponent = Integer.parseInt(memParts[1]);
            } else exponent = 0;

            if (!String.valueOf(coefficient.charAt(coefficient.length() - 1)).matches("[0-9]")) {
                if (coefficient.equals("x")) coefficient = "1";
                else if (coefficient.equals("-x")) coefficient = "-1";
                else coefficient = coefficient.substring(0, coefficient.length() - 1);
                exponent = (memParts.length != 1) ? exponent : 1;
            }

            this.add(Integer.parseInt(coefficient), exponent);
        }
    }

    void add(int coefficient, int exponent) {
        Node current = first;
        for (int i = 0; i < size; i++) {
            current = current.next;
        }
        current.next = new Node(coefficient, exponent, null);
        size++;
    }

    Node node(int index) {
        Node x = first.next;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    int size() {
        return size;
    }

    void printPolynomial() {
        if (size == 0) return;
        for (int i = 0; i < size; i++) {
            Node cur = node(i);
            if (cur.coefficient > 0 && i != 0) System.out.print("+");

            if (cur.exponent == 1) {
                if (cur.coefficient != 1)
                    System.out.print(node(i).coefficient + "x");
                else System.out.print("x");
            }
            else if (cur.exponent != 0) {
                if (cur.coefficient == 1) System.out.print("x^" + node(i).exponent);
                else if (cur.coefficient == -1) System.out.print("-x^" + node(i).exponent);
                else System.out.print(node(i).coefficient + "x^" + node(i).exponent);
            } else System.out.print(node(i).coefficient);
        }
        System.out.println();
    }

    static class Node {
        int coefficient;
        int exponent;
        Node next;

        public Node(int coefficient, int exponent, Node next) {
            this.coefficient = coefficient;
            this.exponent = exponent;
            this.next = next;
        }
    }

}