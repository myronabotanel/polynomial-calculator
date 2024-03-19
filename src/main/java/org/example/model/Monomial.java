package org.example.model;

public class Monomial {
    private int exponent;
    private double coeficient;

    public Monomial(int exponent, double coeficient) {
        this.exponent = exponent;
        this.coeficient = coeficient;
    }

    public int getExponent() {
        return exponent;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    @Override
    public String toString() {
        return String.format("%.2fx^%d", coeficient, exponent);
    }

}
