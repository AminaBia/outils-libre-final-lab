package org.example;

import java.util.List;

public class App {

    public double calculate(List<Double> prices, List<Integer> quantities,
                             String customerType, String discountCode) {

        // Calculate subtotal
        double subtotal = 0;
        for (int i = 0; i < prices.size(); i++) {
            subtotal += prices.get(i) * quantities.get(i);
        }

        // Apply discount
        double discount = 0;
        if (discountCode.equals("SAVE10")) {
            discount = subtotal * 0.10;
        } else if (discountCode.equals("SAVE20")) {
            discount = subtotal * 0.20;
        } else if (discountCode.equals("SAVE5")) {
            discount = subtotal * 0.05;
        }

        // VIP gets extra 5%
        if (customerType.equals("VIP")) {
            discount += subtotal * 0.05;
        }

        // Calculate tax
        double tax = 0;
        if (customerType.equals("VIP")) {
            tax = (subtotal - discount) * 0.05;
        } else {
            tax = (subtotal - discount) * 0.10;
        }

        // Final price
        double total = subtotal - discount + tax;
        return total;
    }
}