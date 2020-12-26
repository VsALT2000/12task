package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class Main {

    @Test
    void standard() {
        int total = Integer.decode("123456789");
        assertEquals(123456789, total);
    }

    @Test
    void empty() {
        Throwable thrown = assertThrows(NumberFormatException.class, () -> {
            int i = Integer.decode("");
        });
    }
    @Test
    void plus(){
        int total=Integer.decode("+1234567");
        assertEquals(1234567,total);
    }
    @Test
    void minus(){
        int total=Integer.decode("-123456789");
        assertEquals(-123456789,total);
    }
    @Test
    void radixSpecifier1(){
        int total=Integer.decode("0x11a4c9");
        assertEquals(0x11a4c9,total);
    }
    @Test
    void radixSpecifier2(){
        int total=Integer.decode("0X9B9B9B");
        assertEquals(0X9B9B9B,total);
    }
    @Test
    void radixSpecifier3(){
        int total=Integer.decode("#18BEC7");
        assertEquals(0X18BEC7,total);
    }
    @Test
    void radixSpecifier4(){
        int total=Integer.decode("0200");
        assertEquals(0200,total);
    }
    @Test
    void doubleSign(){
        Throwable thrown = assertThrows(NumberFormatException.class, () -> {
            int i=Integer.decode("--123");
        });
        Throwable thrown1 = assertThrows(NumberFormatException.class, () -> {
            int i=Integer.decode("-+123");
        });
        Throwable thrown2 = assertThrows(NumberFormatException.class, () -> {
            int i=Integer.decode("+-123");
        });
        Throwable thrown3 = assertThrows(NumberFormatException.class, () -> {
            int i=Integer.decode("++123");
        });
    }
    @Test
    void minValue(){
        int total=Integer.decode(""+Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE,total);
    }
}