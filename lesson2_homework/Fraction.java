package com.example;

/**
 * Created by lnielsen on 9/11/16.
 */
public class Fraction {

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString() {
        return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }

    public static int gcd(int m, int n) {
        // Nice! Using min and max. Also logic is simplified (which is what we want)
        int lesser = Math.min(m, n);
        int greater = Math.max(m,n);

        if (lesser == 0)
            return greater;
        return gcd(lesser, greater % lesser);
    }

    public void simplify() {
        // Avoid naming variables something like gcdd (with an intentional typo). 
        // If you want to use a keywork like gcd, you could say mGcd or some variation 
        int gcdd = gcd(numerator, denominator);
        if (gcdd != 0) {
            numerator = numerator / gcdd;
            denominator = denominator / gcdd;
        }
    }

    public Fraction add(Fraction otherFrac) {
        int newNumer = numerator * otherFrac.getDenominator() + otherFrac.getNumerator() * denominator;
        int newDenom = denominator * otherFrac.getDenominator();
        Fraction newFrac = new Fraction(newNumer, newDenom);
        newFrac.simplify();
        return newFrac;
    }


}
