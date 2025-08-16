package com.rdhadge;

import java.util.HashMap;
import java.util.Map;

public class CollectionsExamples {

    public CollectionsExamples() {
        hashMapBasic();
    }

    private static void hashMapBasic() {
        // create hashmap
        Map<Integer, String> map = new HashMap<>();

        // add elements
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        // same values allowed
        map.put(11, "one");
        System.out.println("Printing partial map");
        map.forEach((key, value) -> System.out.print(key + "->" + value + ","));
        System.out.println("\n");

        // same keys not allowed - it will replace the value for particular key
        map.put(11, "eleven");

        // null value allowed
        map.put(4, null);

        // null key allowed
        map.put(null, "null");

        // print map
        System.out.println("Printing complete map");
        map.forEach((key, value) -> System.out.print(key + "->" + value + ","));
        System.out.println("\n");

        // remove elements
        System.out.println("Printing map after first removal");
        map.remove(1);
        map.forEach((key, value) -> System.out.print(key + "->" + value + ","));
        System.out.println("\n");
        
        System.out.println("Printing map after second removal");
        map.remove(null);
        map.forEach((key, value) -> System.out.print(key + "->" + value + ","));
        System.out.println("\n");
    }
    
}
