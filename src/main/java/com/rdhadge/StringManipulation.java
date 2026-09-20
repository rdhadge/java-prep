package com.rdhadge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringManipulation {

    // input string
    public static String input = "Use this editor to write, compile and run your Java code online";
    
    // public constructor
    public StringManipulation() {
        System.out.println("Input string - " + input);
        printReversedStringCharacters();
        printReversedStringWords();
        printReversedStringWordsUsingStream();
        printFirstRepeatingCharacter();
        printFirstNonRepeatingCharacter();
        printStringRemovingDuplicates();
        printStringRemovingDuplicateChars();
        countFrequencyOfWordsUsingStreams();
        countFrequencyOfWords();
    }

    // complete string reversed - all characters reversed
    private static void printReversedStringCharacters() {
        for (int i = input.length() - 1; i>=0; i--) {
            System.out.print(input.charAt(i));
        }
        System.out.println();
    }
    
    // complete string reversed - all words reversed
    private static void printReversedStringWords() {
        String[] sentence = input.split(" ");
        for (int i = sentence.length -1; i>=0; i--) {
            System.out.print(sentence[i] + " ");
        }
        System.out.println();
    }
    
    // array reverse - streams
    private static void printReversedStringWordsUsingStream() {
        String[] sentence = input.split(" ");
        List<String> sentenceList = Arrays.asList(sentence);
        Collections.reverse(sentenceList);
        sentenceList.forEach(str -> System.out.print(str + " "));
        System.out.println();
    }

    // find first repeating character
    private static void printFirstRepeatingCharacter() {
        String inputString = input.toLowerCase();
        for (char c : inputString.toCharArray()) {
            if (inputString.indexOf(c) != inputString.lastIndexOf(c)) {
                System.out.println("First repeating character - " + c);
                break;
            }
        }
    }

    // find first non-repeating character
    private static void printFirstNonRepeatingCharacter() {
        String str = """
            Multi-tenancy is an architecture where a single software instance and 
            its underlying infrastructure serve multiple distinct customer organizations called tenants.
            
            In a multi-tenant SaaS environment, every tenant shares the same application, compute resources, 
            and often the same database engine, yet each tenant's data, configurations, and user permissions 
            remain completely segregated and private. """;

        System.out.println("getFirstNonRepeatingCharacterUsingIndexOf");
        long startTime = System.nanoTime();
        char firstNonRepeatingChar = getFirstNonRepeatingCharacterUsingIndexOf(str);
        // End timer
        long endTime = System.nanoTime();
        long duration = endTime - startTime; // Duration in nanoseconds
        System.out.println(String.format("First non repeating character: %c, time taken: %d", firstNonRepeatingChar, duration));

        System.out.println("getFirstNonRepeatingCharacterWithoutCharArray");
        startTime = System.nanoTime();
        firstNonRepeatingChar = getFirstNonRepeatingCharacterWithoutCharArray(str);
        endTime = System.nanoTime();
        duration = endTime - startTime; // Duration in nanoseconds
        System.out.println(String.format("First non repeating character: %c, time taken: %d", firstNonRepeatingChar, duration));

        System.out.println("getFirstNonRepeatingCharacterUsingMap");
        startTime = System.nanoTime();
        firstNonRepeatingChar = getFirstNonRepeatingCharacterUsingMap(str);
        endTime = System.nanoTime();
        duration = endTime - startTime; // Duration in nanoseconds
        System.out.println(String.format("First non repeating character: %c, time taken: %d", firstNonRepeatingChar, duration));

        System.out.println("getFirstNonRepeatingCharacterWithArrayCounter");
        startTime = System.nanoTime();
        firstNonRepeatingChar = getFirstNonRepeatingCharacterWithArrayCounter(str);
        endTime = System.nanoTime();
        duration = endTime - startTime; // Duration in nanoseconds
        System.out.println(String.format("First non repeating character: %c, time taken: %d", firstNonRepeatingChar, duration));
    }

    public static char getFirstNonRepeatingCharacterUsingIndexOf(String str) {
        for (char c: str.toCharArray()) {
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                return c;
            }
        }
        return '\0';
    }

    public static char getFirstNonRepeatingCharacterWithoutCharArray(String str) {
        for (int i=0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                return c;
            }
        }
        return '\0';
    }

    public static char getFirstNonRepeatingCharacterUsingMap(String str) {
        Map<Character, Integer> charMap = new LinkedHashMap<Character, Integer>(str.length());
        
        for (int i=0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry: charMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0';
    }

    public static char getFirstNonRepeatingCharacterWithArrayCounter(String str) {
        int[] count = new int[str.length()]; 

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (count[c] == 1) {
                return c;
            }
        }
        return '\0';
    }

    // remove duplicate words from string
    private static void printStringRemovingDuplicates() {
        input = "Use this editor to, compile and your Java code Use this editor to write, compile and run your Java online this editor to write, compile and run your Java code";
        String[] inputWords = input.toLowerCase().split(" ");
        List<String> words = new ArrayList<>(Arrays.asList(inputWords));
        
        // using set
        Set<String> removedDuplicates = new HashSet<>(words);
        removedDuplicates.forEach(str -> System.out.print(str + " "));
        System.out.println();
    }

    // remove duplicate characters from string
    private static void printStringRemovingDuplicateChars() {
        input = "Use this editor to, compile and your Java code Use this editor to write, compile and run your Java online this editor to write, compile and run your Java code";
        
        // using streams (removing duplicate characters)
        input.toLowerCase()
            .chars()
            .distinct()
            .forEach(str -> System.out.print(String.valueOf((char) str) + " "));

        System.out.println();
    }

    // count frequency of words using streams
    private static void countFrequencyOfWordsUsingStreams() {
        input = "Use this editor to, compile and your Java code Use this editor to write, compile and run your Java online this editor to write, compile and run your Java code";

        Arrays.stream(
            input.toLowerCase()
                .replaceAll("[-+.^:,]","")
                .split(" "))
                .forEach(k -> System.out.print(k + ","));
        System.out.println();
        
        Arrays.stream(
            input.toLowerCase()
                .replaceAll("[-+.^:,]","")
                .split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k,v) -> System.out.print(k + "->" + v + ","));
        System.out.println();
    }

    // count frequency of words
    private static void countFrequencyOfWords() {
        input = "Use this editor to, compile and your Java code Use this editor to write, compile and run your Java online this editor to write, compile and run your Java code";
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : input.toLowerCase().replaceAll("[-+.^:,]","").split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        wordCount.forEach((k,v) -> System.out.print(k + "->" + v + ","));
        System.out.println();
    }
}
