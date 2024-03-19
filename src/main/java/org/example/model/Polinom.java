package org.example.model;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Polinom {
    private Map<Integer, Monomial> polinom;  //la mine, cheia este exponentul

    public Polinom(Map<Integer, Monomial> polinom) {
        this.polinom = polinom;
    }

    public Polinom() {
        this.polinom = new HashMap<>();
    }

    public Polinom(String input)  {
        Map<Integer, Monomial> result = new HashMap<>();
        Pattern pattern = Pattern.compile("((-?\\d+(?=x))?(-?[x])(\\^(-?\\d+))?)|((-?)[x])|(-?\\d+)"); //string ul respecta regula:  "ax^b", "+/-x^b", "+/-x", sau constante simple.
        input = input.replaceAll("\\s", "");
        input = input.replaceAll("\\*", "");
        Matcher matcher = pattern.matcher(input);
        double coefficient = 0;
        int exponent = 0;
        boolean isValid = false;
        while (matcher.find()) {
            isValid = true;
            if (matcher.group(3) != null && matcher.group(2) != null) { //the monomial of the form ax^b

                exponent = (matcher.group(5) != null ? Integer.parseInt(matcher.group(5)) : 1);
                coefficient = Integer.parseInt(matcher.group(2));
            } else if (matcher.group(3) != null && matcher.group(2) == null) { //the monomial of the form +/-x^b or +/-x
                if (matcher.group(3).equals("-x")) {
                    coefficient = -1;
                } else {
                    coefficient = 1;
                }
                exponent = (matcher.group(5) != null ? Integer.parseInt(matcher.group(5)) : 1);
            } else if (matcher.group(3) == null && matcher.group(2) == null) { //the constant monomial, without x
                coefficient = Integer.parseInt(matcher.group());
            }
            result.put(exponent, new Monomial(exponent, coefficient));
            coefficient = 0;
            exponent = 0;
        }
        if(!isValid) {
            JOptionPane.showMessageDialog(null, "Invalid polynomial\n", "Error", JOptionPane.ERROR_MESSAGE);
            this.polinom.clear();
        }
        this.polinom = result;
    }
    public boolean isZero () {
        //verificam daca polinomul e un nr ct
        return polinom.size() == 1 && polinom.containsKey(0) && polinom.get(0).getCoeficient()==0;
    }
    public int degree () {
        if (isZero()){
            return 0;
        }
        int maxExponent = Integer.MAX_VALUE;
        for(int exponent : polinom.keySet()){
            if(exponent > maxExponent)
            {
                maxExponent = exponent;
            }
        }
        return maxExponent;
    }
    public Monomial getHighestTerm (){
        if(polinom.isEmpty()) {
            return null;
        }
        int maxExponent = Integer.MIN_VALUE;
        Monomial highestTerm = null;

        for (Monomial monomial : polinom.values()) {
            if (monomial.getExponent() > maxExponent) {
                maxExponent = monomial.getExponent();
                highestTerm = monomial;
            }
        }

        return highestTerm;
    }

    public Map<Integer, Monomial> getPolinom() {
        return this.polinom;
    }

    public void setPolinom(Map<Integer, Monomial> polinom) {
        this.polinom = polinom;
    }

    @Override
    public String toString() {
        //ordonam descrescator Map ul
        ArrayList<Integer> sortedExponents = new ArrayList<>(polinom.keySet());
        Collections.sort(sortedExponents, Collections.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;

        for (Integer exponent : sortedExponents) {
            double coefficient =polinom.get(exponent).getCoeficient();
            if (!first) {
                if (coefficient >= 0) {
                    stringBuilder.append(" + ");
                } else {
                    stringBuilder.append(" - ");
                    coefficient = Math.abs(coefficient);
                }
            } else {
                first = false;
            }

            if (exponent == 0) {
                stringBuilder.append(coefficient);
            } else {
                if (coefficient != 1) {
                    stringBuilder.append(coefficient);
                }
                stringBuilder.append("x");
                if (exponent != 1) {
                    stringBuilder.append("^").append(exponent);
                }
            }
        }

        if (stringBuilder.length() == 0) {
            stringBuilder.append("0"); // Dacă polinomul este gol
        }

        return stringBuilder.toString();
    }
}
