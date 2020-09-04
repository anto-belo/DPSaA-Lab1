package com.lab1;

public class Main {

    private static Polynomial polynomial;

    public static void main(String[] args) {

        polynomial = new Polynomial();

        String polynomial_1 = "-5x^4+7x^3-4x^2+6x+7";
        fillPolynomial(polynomial, getMembersArray(polynomial_1));
    }

    private static void fillPolynomial(Polynomial p, String[] members) {
        for (String member : members) {
            String[] memParts = member.split("\\^");
            String basis = memParts[0];
            int degree;

            if (memParts.length != 1) {
                degree = Integer.parseInt(memParts[1]);
            } else degree = 0;

            if (!String.valueOf(basis.charAt(basis.length() - 1)).matches("[0-9]")) {
                basis = basis.substring(0, basis.length() - 1);
                degree = (memParts.length != 1) ? degree : 1;
            }

            p.add(Integer.parseInt(basis), degree);
        }
    }

    private static String[] getMembersArray(String polynomial) {
        StringBuilder members = new StringBuilder();
        int offset = 0;
        for (int i = 1; i < polynomial.length(); i++) {
            if (polynomial.charAt(i) == '+') {
                members.append(polynomial, offset, i).append("|");
                offset = i + 1;
            } else if (polynomial.charAt(i) == '-') {
                members.append(polynomial, offset, i).append("|");
                offset = i;
            } else if (i == polynomial.length() - 1) {
                members.append(polynomial, offset, i + 1);
            }
        }
        return members.toString().split("\\|");
    }
}