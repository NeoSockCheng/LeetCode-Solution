package Template;

import java.util.HashMap;

public class HashMapJava {
    public static void main(String[] args) {
        // Create a HashMap object
        HashMap<String, Integer> map = new HashMap<>();

        // Add elements to the HashMap
        map.put("Alice", 25);

        // Get the value associated with a specific key
        int ageOfBob = map.get("Bob");

        // Check if a key exists in the HashMap
        boolean hasCharlie = map.containsKey("Charlie");

        // Check if a value exists in the HashMap
        boolean hasAge25 = map.containsValue(25);

        // Remove an element by key
        map.remove("Alice");

        // Get the size of the HashMap
        int size = map.size();

        // Iterate over the HashMap
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        // Clear all elements in the HashMap
        map.clear();
    }
}

/*
 * use case: fast lookup, undordered data, handle null values
 * edge case: empty map, should not have NULL key, large map
 */