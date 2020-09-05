package com.lab1;

import com.lab1.Polynomial.Node;

public class Main {

    public static void main(String[] args) {

        Polynomial p = new Polynomial("-5x^4+7x^3-4x^2+6x+7");
        Polynomial q = new Polynomial("6x^6+5x^4+x^2-3x+4");
        System.out.println(equality(p, q));

        q = new Polynomial("-5x^4+7x^3-4x^2+6x+7");
        System.out.println(equality(p, q));

        System.out.println(meaning(q, 1));
        System.out.println(meaning(q, 2));

        Polynomial s = new Polynomial();
        add(s, new Polynomial("5x^6+3x^3-2x+4"), new Polynomial("7x^8-6x^6+4x^4-x"));
        s.printPolynomial();

        s = new Polynomial();
        add(s, new Polynomial("4x^8-7x^6+10x^5-2x^2+1"), new Polynomial("5x^9-4x^8+9x^7-2x^4+3x-8"));
        s.printPolynomial();
    }

    private static boolean equality(Polynomial p, Polynomial q) {
        if (p.size() != q.size()) return false;
        for (int i = 0; i < p.size(); i++) {
            Node polyP = p.node(i);
            Node polyQ = q.node(i);
            if (polyP.coefficient != polyQ.coefficient ||
                    polyP.exponent != polyQ.exponent)
                return false;
        }
        return true;
    }

    private static int meaning(Polynomial p, int x) {
        int res = 0;
        for (int i = 0; i < p.size(); i++) {
            Node n = p.node(i);
            res += n.coefficient * Math.pow(x, n.exponent);
        }
        return res;
    }

    private static void add(Polynomial p, Polynomial q, Polynomial r) {
        boolean qF = true, rF = true;
        int qOff = 0, rOff = 0;
        while(qF || rF) {
            Node qN = q.node(qOff);
            Node rN = r.node(rOff);
            if ((qF && !rF) || qN.exponent > rN.exponent) {
                p.add(qN.coefficient, qN.exponent);
                qOff++;
                qF = qOff != q.size();
            } else if (!qF || qN.exponent < rN.exponent){
                p.add(rN.coefficient, rN.exponent);
                rOff++;
                rF = rOff != r.size();
            } else {
                if (qN.coefficient + rN.coefficient != 0)
                    p.add(qN.coefficient + rN.coefficient, qN.exponent);
                qOff++;
                qF = qOff != q.size();
                rOff++;
                rF = rOff != r.size();
            }
        }
    }
}