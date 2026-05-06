package org.example;

import org.junit.Test;


import static org.junit.Assert.*;
import java.util.Arrays;

public class AppTest {

    App app = new App();

    @Test
    public void testBasicCalculation() {
        double result = app.calculate(
            Arrays.asList(100.0, 50.0),
            Arrays.asList(2, 3),
            "REGULAR",
            "NONE"
        );
        // subtotal = 350, tax = 35, total = 385
        assertEquals(385.0, result, 0.01);
    }

    @Test
    public void testSave10Discount() {
        double result = app.calculate(
            Arrays.asList(100.0),
            Arrays.asList(1),
            "REGULAR",
            "SAVE10"
        );
        // subtotal = 100, discount = 10, tax = 9, total = 99
        assertEquals(99.0, result, 0.01);
    }

    @Test
    public void testVIPDiscount() {
        double result = app.calculate(
            Arrays.asList(100.0),
            Arrays.asList(1),
            "VIP",
            "NONE"
        );
        // subtotal = 100, discount = 5, tax = 4.75, total = 99.75
        assertEquals(99.75, result, 0.01);
    }
    @Test
    public void testSave20Discount() {
        double result = app.calculate(
            Arrays.asList(200.0),
            Arrays.asList(1),
            "REGULAR",
            "SAVE20"
        );
        // subtotal = 200, discount = 40, tax = 16, total = 176
        assertEquals(176.0, result, 0.01);
    }
}
