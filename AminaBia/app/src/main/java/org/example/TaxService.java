package org.example;

public class TaxService {

    public double calculateTax(double subtotal, double discount, String customerType) {
        if (customerType.equals("VIP")) {
            return (subtotal - discount) * 0.05;
        } else {
            return (subtotal - discount) * 0.10;
        }
    }
}
