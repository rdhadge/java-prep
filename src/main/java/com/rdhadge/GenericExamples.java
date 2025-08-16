package com.rdhadge;

public class GenericExamples {

    public GenericExamples() {
        checkIfPalindrome(122221);
    }

    // check if number is palindrome
    private static void checkIfPalindrome(int num) {

        int tempVar = num;
        double reversedNum = 0;

        while(tempVar != 0) {
            reversedNum = (reversedNum * 10) + (tempVar % 10);
            tempVar = tempVar / 10;
        }

        System.out.println(
            String.format("%d is %s palindrome", num, (reversedNum == num? "a" : "not a")));
        
    }
    
}
