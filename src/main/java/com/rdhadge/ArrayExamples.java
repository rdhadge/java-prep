package com.rdhadge;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayExamples {

    public ArrayExamples() {
        
    }

    // find missng number in array 1..n
    public long findMissingNumber(int[] numbers, int maxNumber) {
        long actualSum = Arrays.stream(numbers).sum();
        long expectedSum = IntStream.rangeClosed(1, maxNumber).sum();

        return expectedSum - actualSum;
    }
    
}
