package com.lab1;

public class Main2 {

    public static void main(String[] args) {

        int k = 3;
        for (int n = 1; n <= 64; n++) {
            ChildCircle cc = new ChildCircle(n);

            int index = 0;
            while (cc.size() != 1) {
                index += k;
                int number = cc.get(index);
                cc.delete(index);
                System.out.println("Child #" + number + " deleted");
            }
            System.out.printf("%2d children: #" + cc.get(0) + " is the last\n", n);
        }
    }
}
