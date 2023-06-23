package com.acme;

import com.acme.model.Console;
import java.text.DecimalFormat;

public class Main {

  public static void main(String[] args) {
    System.out.println("Bond calculator!!!");

   int principal = Console.readNumber("Principal: ", 1000, 1_000_000);
   float interestRatePerYear = (float) Console.readNumber("Interest rate: ", 0, 30);
   byte  years = (byte) Console.readNumber("Period (Years):", 0, 30);

    BondCalculator bond = new BondCalculator(
      principal,
      interestRatePerYear,
      years
    );
    bond.printInstallment();
    bond.printSchedule();
  }
}
