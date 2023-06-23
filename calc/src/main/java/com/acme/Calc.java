package com.acme;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Calc extends PrintInfo {
    /*
     * - PERCENT and MONTHS_IN_YEAR are final/constants because there are not
     * going to change during bond calcualtions.
     * 
     * - Percent, months_in_year, principal, interestRatePerYear, years are private
     * so that ONLY the
     * current instance has access and can manipulate 'ENCAPSULATION'.
     * By encapsulating we can ensure that the variables are accessed and modified
     * in a controlled manner,
     * maintaining data integrity and encapsulating the implementation details of
     * the class.
     * 
     */
    private final byte PERCENT = 100;
    private final byte MONTHS_IN_YEAR = 12;
    private int principal;
    private float interestRatePerYear;
    private byte years;

    public Calc(int _principal, float _rate, byte _years) throws IllegalArgumentException {
        // Exceptions for test cases
        if (_principal < 1000 || _principal > 1000000) {
            throw new IllegalArgumentException("Principal should be between 1000 - 1 000 000");
        }

        if (_rate < 0 || _rate > 30) {
            throw new IllegalArgumentException("Rate should be between 0 - 30 %");
        }

        if (_years < 0 || _years > 30) {
            throw new IllegalArgumentException("Pearid should be between 0 - 30 years");
        }

        this.principal = _principal;
        this.interestRatePerYear = _rate;
        this.years = _years;
    }

    private double[] calculateRemainingLoanBalance() {
        float interestRatePerMonth = getInterestRatePerMonth();
        short numberOfPayments = getNumberOfPayments();
        double[] remainBalances = new double[numberOfPayments];

        for (int i = 1; i <= numberOfPayments; i++) {
            double remainingLoanBalance = principal
                    * (Math.pow(1 + interestRatePerMonth, numberOfPayments) - Math.pow(1 + interestRatePerMonth, i))
                    / (Math.pow(1 + interestRatePerMonth, numberOfPayments) - 1);
            remainBalances[i - 1] = remainingLoanBalance;
        }
        return remainBalances;
    }

    public double calculateBondInstalment() {
        float interestRatePerMonth = getInterestRatePerMonth();
        short numberOfPayments = getNumberOfPayments();
        double instalmentAmount = principal
                * (interestRatePerMonth * Math.pow(1 + interestRatePerMonth, numberOfPayments))
                / (Math.pow(1 + interestRatePerMonth, numberOfPayments) - 1);

        return instalmentAmount;
    }

    private short getNumberOfPayments() {

        return (short) (this.years * MONTHS_IN_YEAR);
    }

    private float getInterestRatePerMonth() {
        return this.interestRatePerYear / PERCENT / MONTHS_IN_YEAR;
    }

    public void printInstallment() {
        printBondInstalmentAmount(calculateBondInstalment());

    }

    public void printSchedule() {
        printBondSchedule(calculateRemainingLoanBalance());

    }

    // Polymorphism: method overloading
    public void printSchedule(LocalDateTime date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);

        printBondSchedule(calculateRemainingLoanBalance(), strDate);

    }

    // Polymorphism Method overriding, change currency from USD to ZAR,
    public String FormatToZar(double value) {
        double y = Math.floor(value * 100) / 100;
        DecimalFormat df = new DecimalFormat("#####0.00");

        return "ZAR" + df.format(y);
    }

}