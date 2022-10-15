package me.oriol;

import java.util.Scanner;

public class Console {

    private float readNumber(String prompt, float min, int max) {
        var scanner = new Scanner(System.in);
        while (true) {
            float value;

            System.out.print(prompt + ": ");
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                return value;
            System.out.println("Enter a number between " + (short) min + " and " + max + ".");
        }
    }
    public int principal = (int)
            readNumber("Principal", 1000, 1_000_000);
    public float monthlyInterest =
            readNumber("Annual Interest Rate", 0.1F, 30) / MONTHS_IN_YEAR / PERCENT;
    public int numberOfPayments = (short)
            readNumber("Period (Years)", 1, 30) * MONTHS_IN_YEAR;
}