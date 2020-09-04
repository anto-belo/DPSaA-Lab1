package com.lab1;

import com.lab1.Polynomial.Node;

public class Main {

    public static void main(String[] args) {

        Polynomial p = new Polynomial("-5x^4+7x^3-4x^2+6x+7");
        Polynomial q = new Polynomial("6x^6+5x^4+x^2-3x+4");
        System.out.println(equality(p, q));

        q = new Polynomial("-5x^4+7x^3-4x^2+6x+7");
        System.out.println(equality(p, q));

        System.out.println(meaning(q, 2));

        /*Polynomial s = new Polynomial();
        add(s, new Polynomial("5x^6+3x^3-2x+4"), new Polynomial("7x^8-6x^6+4x^4-x"));
        s.printPolynomial();*/
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

    // UNDER CONSTRUCTION UNDER CONSTRUCTION UNDER CONSTRUCTION UNDER CONSTRUCTION
    
    /*private static void add(Polynomial p, Polynomial q, Polynomial r) {
        Polynomial b = q;
        Polynomial s = r;
        if (Math.min(q.size(), r.size()) == q.size()) {
            b = r;
            s = q;
        }

        for (int i = 0; i < s.size(); i++) {
            Node in = s.node(i);
            for (int j = 0; j < b.size(); j++) {
                Node form = b.node(i);
                if (form.exponent == in.exponent)
                    p.add(form.coefficient + in.coefficient, in.exponent);
                else if (in.exponent > form.exponent)
                    p.add(in.coefficient, in.exponent);
                else p.add(form.coefficient, form.exponent);
            }
        }
    }*/
}