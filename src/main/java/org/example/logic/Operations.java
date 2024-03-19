package org.example.logic;

import org.example.model.Monomial;
import org.example.model.Polinom;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Operations {
    public  static Polinom addPolynomials (Polinom p1, Polinom p2)
    {
        Map<Integer, Monomial> result = new HashMap<>(p1.getPolinom());
        for(Map.Entry<Integer, Monomial> entry : p2.getPolinom().entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue().getCoeficient();
            if(result.containsKey(exponent))
            {
                double oldCoefficient = result.get(exponent).getCoeficient();
                if(oldCoefficient + coefficient !=0 ){
                result.put(exponent, new Monomial(exponent, oldCoefficient + coefficient));
                }
            }
            else {
                result.put(exponent, new Monomial(exponent, coefficient));
            }
        }
        return new Polinom(result);
    }
    public  static Polinom opus (Polinom polinom)
    {
        Map<Integer, Monomial> result = new HashMap<>();
        for(Map.Entry<Integer, Monomial> entry : polinom.getPolinom().entrySet())
        {
            int exponent = entry.getKey();
            double coefficient = (-1)* entry.getValue().getCoeficient();
            result.put(exponent, new Monomial(exponent, coefficient));
        }
        return new Polinom(result);
    }
    public static Polinom subtract(Polinom p1, Polinom p2) {
        Map<Integer, Monomial> result = new HashMap<>();

        // Adăugăm termenii din p1 in rezultat
        for (Map.Entry<Integer, Monomial> entry : p1.getPolinom().entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue().getCoeficient();
            result.put(exponent, new Monomial(exponent, coefficient));
        }

        // Scadem termenii din p2 din rezultat
        for (Map.Entry<Integer, Monomial> entry : p2.getPolinom().entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue().getCoeficient();

            // Dacă există deja un termen cu aceeași putere în rezultat, scădem coeficientul
            if (result.containsKey(exponent)) {
                double oldCoefficient = result.get(exponent).getCoeficient();
                double newCoefficient = oldCoefficient - coefficient;
                result.put(exponent, new Monomial(exponent, newCoefficient));
            } else {
                // Dacă nu există un termen cu aceeași putere în rezultat, adăugăm termenul negativ
                result.put(exponent, new Monomial(exponent, -coefficient));
            }
        }
        // Eliminăm termenii cu coeficientul zero din rezultat
        result.entrySet().removeIf(entry -> entry.getValue().getCoeficient() == 0);

        return new Polinom(result);
    }

    public static Polinom multiply (Polinom p1, Polinom p2) {
        Map<Integer, Monomial> result = new HashMap<>();

        for (Map.Entry<Integer, Monomial> entry1 : p1.getPolinom().entrySet()) {
            int exponent1 = entry1.getKey();
            double coefficient1 = entry1.getValue().getCoeficient();

            for (Map.Entry<Integer, Monomial> entry2 : p2.getPolinom().entrySet()) {
                int exponent2 = entry2.getKey();
                double coefficient2 = entry2.getValue().getCoeficient();

                int newExp = exponent1 + exponent2;
                double newCoefficient = coefficient1 * coefficient2;

                if (result.containsKey(newExp)) {
                    double oldCoef = result.get(newExp).getCoeficient();
                    result.put(newExp, new Monomial(newExp, oldCoef + newCoefficient));
                } else {
                    result.put(newExp, new Monomial(newExp, newCoefficient));
                }
            }
        }

        return new Polinom(result);
    }
    public static Polinom derivative (Polinom polinom)
    {
        Map<Integer, Monomial> result = new HashMap<>();
        for(Map.Entry<Integer, Monomial> entry : polinom.getPolinom().entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue().getCoeficient();
            coefficient = coefficient * exponent;
            if(exponent != 0 )
            {
                exponent -- ;
            }
            result.put(exponent, new Monomial(exponent, coefficient));
        }
        return new Polinom(result);
    }
    public static Polinom integration (Polinom polinom)
    {
        Map<Integer, Monomial> result = new HashMap<>();
        for(Map.Entry<Integer, Monomial> entry : polinom.getPolinom().entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue().getCoeficient();
            if(exponent!=-1)
            {
                double newCoefficient = coefficient / (exponent+1);
                result.put(exponent+1, new Monomial(exponent+1, newCoefficient));
            }
            else {
                result.put(-1, new Monomial(-1, coefficient));
            }
        }
        return new Polinom(result);
    }
    public static String divide(Polinom dividend, Polinom divisor) {
        if (divisor.isZero()) {
            System.out.println("EROARE. NU AI VOIE SA IMPARTI LA 0");
            return null;
        }

        Polinom result = new Polinom();
        Polinom remainder = new Polinom(dividend.getPolinom());

        while (true) {
            Monomial highestDividendTerm = remainder.getHighestTerm();
            Monomial highestDivisorTerm = divisor.getHighestTerm();

            if (highestDividendTerm == null || highestDividendTerm.getExponent() < highestDivisorTerm.getExponent()) {
                break;
            }

            double newCoefficient = highestDividendTerm.getCoeficient() / highestDivisorTerm.getCoeficient();
            int newExponent = highestDividendTerm.getExponent() - highestDivisorTerm.getExponent();

            Map<Integer, Monomial> term = new HashMap<>();
            term.put(newExponent, new Monomial(newExponent, newCoefficient));
            Polinom termPolynomial = new Polinom(term);
            Polinom termResult = Operations.multiply(termPolynomial, divisor);

            result = Operations.addPolynomials(result, termPolynomial);
            remainder = Operations.subtract(remainder, termResult);
        }

        String sb = "Q: " + result.toString() + "; R: "+ remainder.toString();
        return sb;
    }


}
