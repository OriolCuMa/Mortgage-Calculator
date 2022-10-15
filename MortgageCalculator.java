package me.oriol;

public class MortgageCalculator {

    private static final int MONTH_IN_YEAR = 12;

    private final double principal;
    private final double monthlyInterest;
    private final int numberOfPayments;

    public MortgageCalculator(double principal, double annualInterest, int years) {
        this.principal = principal;
        this.monthlyInterest = annualInterest / MONTH_IN_YEAR;
        this.numberOfPayments = years * MONTH_IN_YEAR;
    }

    public double calculateMortgage() {
        return principal
                * monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    private double calculateBalance(short numberOfPaymentsMade) {
        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double[] getRemainingBalances() {
        var balances = new double[numberOfPayments];
        for (short month = 1; month <= balances.length; month++)
            balances[month -1] = calculateBalance(month);
        return balances;
    }
}