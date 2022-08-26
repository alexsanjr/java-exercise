package util;

public class CurrencyConverter {
    public static final double IOF = 0.06;

    public static double amountPaid(double dollarPrice, double amount) {
        return dollarPrice * amount + 0.06 * (dollarPrice * amount);
    }
}
