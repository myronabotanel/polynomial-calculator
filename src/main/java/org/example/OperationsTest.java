package org.example;

import org.example.logic.Operations;
import org.example.model.Monomial;
import org.example.model.Polinom;
import org.junit.Test;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OperationsTest
{
    @Test
    public void addTest()
    {
        String s1 = "x^3 - 2x + 16";
        String s2 = "x^2 + 19x+120";
        Polinom polinom1 = new Polinom(s1);
        Polinom polinom2 = new Polinom (s2);

        Polinom expectedResult = new Polinom("x^3 + x^2 +17x +136");
        Polinom realResult = new Operations().addPolynomials (polinom1, polinom2);

        assertEquals (realResult.toString(), expectedResult.toString());

    }
    @Test
    public void substractTest ()
    {
        String s1 = "x+19";
        String s2 ="x^2 +19";
        Polinom p1 = new Polinom(s1);
        Polinom p2 = new Polinom(s2);
        Polinom myResult = new Polinom("-x^3 -x");
        Polinom realResult = new Operations().subtract (p1, p2);
        assertEquals(realResult.toString(), myResult.toString());
    }
    @Test
    public void multyplicateTest ()
    {
        String s1 = "x+19";
        String s2 ="x^2 +19";
        Polinom p1 = new Polinom(s1);
        Polinom p2 = new Polinom(s2);
        Polinom myResult = new Polinom("-x^2 -x");
        Polinom realResult = new Operations().multiply (p1, p2);
        assertEquals(realResult.toString(), myResult.toString());
    }

    @Test
    public void derivativeTest()
    {
        String s = "x^7+3x^2+100";
        Polinom polinom = new Polinom(s);
        Polinom myResult = new Polinom("7x^6+6x+0.0");
        Polinom realResult = new Operations().derivative(polinom);
        assertEquals(realResult.toString(), myResult.toString());
    }
    @Test
    public void integrationTest()
    {
        String s = "x^7+3x^2+100";
        Polinom polinom = new Polinom(s);
        Polinom myResult = new Polinom("7x^6+6x+0.0");
        Polinom realResult = new Operations().integration(polinom);
        assertEquals(realResult.toString(), myResult.toString());
    }

    @Test
    public void divideTest()
    {
        String s1 = "3x^3+2x^2-5x+4";
        String s2 = "x-1";
        Polinom p1 = new Polinom(s1);
        Polinom p2 = new Polinom(s2);
        String myResult = "Q: 3.0x^2 + 5.0x; R: 4.0";
        String realResult = new Operations().divide(p1, p2);
        assertEquals(realResult.toString(), myResult.toString());

    }
}
