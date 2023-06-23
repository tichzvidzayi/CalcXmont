package com.acme;

import java.text.DecimalFormat;

public class PrintInfo implements IBondCalculate {

    public PrintInfo() {
        // compiler will add a default constructor if ommitted
    }

    public String FormatToZar(double value) {
        double y = Math.floor(value * 100) / 100;
        DecimalFormat df = new DecimalFormat("#####0.00");

        return "USD" + df.format(y);
    }

    public void printBondInstalmentAmount(double bond_installment) {
        System.out.println(
                "Bond instalment amount = " + FormatToZar(bond_installment));
    }

    public void printBondSchedule(double[] remainingBalance) {
        System.out.println("Bond schedule report : ");
        for (double balance : remainingBalance) {
            System.out.println(FormatToZar(balance));
        }
    }

    // Polymorphism: method overloading
    public void printBondSchedule(double[] remainingBalance, String date) {
        System.out.println("Bond schedule report : ");
        for (double balance : remainingBalance) {
            System.out.println(FormatToZar(balance));
        }
    }
}
