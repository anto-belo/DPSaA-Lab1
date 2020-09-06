package com.lab1;

public class Main2 {

    public static void main(String[] args) {

        int k = 3;
        System.out.println("Every " + k-- + " child is removed");

        for (int n = 1; n <= 64; n++) {
            ChildCircle cc = new ChildCircle(n);
            int index = 0;
            while (cc.size() != 1) {
                index = cc.move(index, k);
                cc.delete(index);
            }
            System.out.printf("%2d children: #" + cc.node(0).e + " is the last\n", n);
        }
    }
}