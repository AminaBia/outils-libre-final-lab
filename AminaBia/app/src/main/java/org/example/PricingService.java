package org.example;

import java.util.List;

public class PricingService {

    private TaxService taxService = new TaxService();

    public double calculateFinalPrice(List<Double> prices, List<Integer> quantities,
                                      String customerType, String discountCode) {

        double subtotal = calculateSubtotal(prices, quantities);
        double discount = calculateDiscount(subtotal, customerType, discountCode);
        double tax = taxService.calculateTax(subtotal, discount, customerType);

        return subtotal - discount + tax;
    }

    private double calculateSubtotal(List<Double> prices, List<Integer> quantities) {
        double subtotal = 0;
        for (int i = 0; i < prices.size(); i++) {
            subtotal += prices.get(i) * quantities.get(i);
        }
        return subtotal;
    }

    private double calculateDiscount(double subtotal, String customerType, String discountCode) {
        double discount = 0;
        if (discountCode.equals("SAVE10")) {
            discount = subtotal * 0.10;
        } else if (discountCode.equals("SAVE20")) {
            discount = subtotal * 0.20;
        } else if (discountCode.equals("SAVE5")) {
            discount = subtotal * 0.05;
        }
        if (customerType.equals("VIP")) {
            discount += subtotal * 0.05;
        }
        return discount;
    }
}
