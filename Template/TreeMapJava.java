package Template;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapJava {
    public static void main(String[] args) {
        // Create a TreeMap object
        TreeMap<String, Integer> map = new TreeMap<>();

        // Add elements to the TreeMap
        map.put("David", 28);

        // Get the value associated with a specific key
        int ageOfBob = map.get("Bob");

        // Get the first and last entry
        System.out.println("First entry: " + map.firstEntry());
        System.out.println("Last entry: " + map.lastEntry());

        // Get a key less than or equal to the specified key
        System.out.println("Floor of Charlie: " + map.floorEntry("Charlie"));

        // Get a key strictly less than the specified key
        System.out.println("Lower of David: " + map.lowerEntry("David"));

        // Iterate over the TreeMap
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        // Remove an element by key
        map.remove("Alice");

        Map.Entry<String, Integer> firstEntry = map.firstEntry();
        System.out.println("First Entry: " + firstEntry);

        // Get first key only
        String firstKey = map.firstKey();
        System.out.println("First Key: " + firstKey);

        // Get first value
        Integer firstValue = map.get(firstKey);
        System.out.println("First Value: " + firstValue);

        // Clear all elements in the TreeMap
        map.clear();
    }
}

/*
 * use case: sorted data, range queries, navigate through data
 * edge case: empty map, should not have NULL key, large map
 */
