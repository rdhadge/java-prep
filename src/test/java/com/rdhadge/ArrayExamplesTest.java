package com.rdhadge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class ArrayExamplesTest {

    ArrayExamples ae = new ArrayExamples();

    @Test
    public void testMissingNumberInArray() {
        int maxNumber = 20;
        int[] numbers = IntStream.range(1, maxNumber).toArray();
        assertEquals(ae.findMissingNumber(numbers, maxNumber), maxNumber, "Incorrect number found");

        maxNumber = 10;
        numbers = IntStream.of(1, 2, 3, 4, 5, 7, 8, 9, 10).toArray();
        assertEquals(ae.findMissingNumber(numbers, maxNumber), 6, "Incorrect number found");
    }
    
}
