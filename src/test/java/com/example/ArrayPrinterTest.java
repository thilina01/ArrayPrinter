package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ArrayPrinterTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void print_arr4x4() {
        new ArrayPrinter().print(Main.arr4x4);
        Assertions.assertEquals("1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10", outputStreamCaptor.toString().trim());
    }

    @Test
    void print_arr5x5() {
        new ArrayPrinter().print(Main.arr5x5);
        Assertions.assertEquals("1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13", outputStreamCaptor.toString().trim());
    }

    @Test
    void print_arr6x6() {
        new ArrayPrinter().print(Main.arr6x6);
        Assertions.assertEquals("1,2,3,4,5,6,12,18,24,30,36,35,34,33,32,31,25,19,13,7,8,9,10,11,17,23,29,28,27,26,20,14,15,16,22,21", outputStreamCaptor.toString().trim());
    }

}