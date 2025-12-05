package com.amalitech.bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void twoPlusTwoEqualsFour(){
        var calculator = new Main();
        assertEquals(4, calculator.SimpleCalculator(2, 2));
    }
}