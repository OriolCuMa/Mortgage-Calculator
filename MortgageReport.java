package me.oriol;

import java.text.NumberFormat;

public class MortgageReport {
    private final MortgageCalculator calculate = new MortgageCalculator();
    private final NumberFormat currency = NumberFormat.getCurrencyInstance();

    public void printMortgage() {
        double mortgage = calculate.calculateMortgage();
        String mortgageCurrency = currency.format(mortgage);
        System.out.println("\nMORTGAGE" + "\n--------" + "\nMonthly Payments: " + mortgageCurrency + "\n");
    }

    public void printPaymentSchedule() {
        System.out.println("PAYMENT SCHEDULE" + "\n----------------");
        for (double balance : calculate.getRemainingBalances())
            System.out.println(currency.format(balance));
        }
    }