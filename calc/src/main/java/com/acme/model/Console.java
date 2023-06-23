package com.acme.model;

import java.util.Scanner;
public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static int readNumber(String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextInt();
            if (value < min || value > max) {
                System.out.println("Value needs to between: " + min + " - " + max);
                continue;
            }
            return value;
        }
    }
}

