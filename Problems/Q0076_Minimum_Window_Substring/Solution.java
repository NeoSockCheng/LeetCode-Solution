package Problems.Q0076_Minimum_Window_Substring;

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int[] minimum = { 0, Integer.MAX_VALUE };
        int start = 0;
        int targetRemainingChar = n;

        for (int end = 0; end < m; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c) && map.get(c) > 0) {
                targetRemainingChar--;
            }
            map.put(c, map.getOrDefault(c, 0) - 1);

            if (targetRemainingChar == 0) {
                while (true) {

                    char d = s.charAt(start);

                    if (map.containsKey(d) && map.get(d) == 0) {
                        break;
                    }
                    map.put(d, map.getOrDefault(d, 0) + 1);
                    start++;
                }

                if (end - start < minimum[1] - minimum[0]) {
                    minimum[0] = start;
                    minimum[1] = end;
                }

                map.put(s.charAt(start),map.get(s.charAt(start))+1);
                targetRemainingChar++;
                start++;

            }
        }
        
        return minimum[1]-minimum[0]<=m? s.substring(minimum[0], minimum[1]+1): "";
    
    }
}

// Question: get the minimum substring of string s where contain all characters in string t
// solution: sliding window
// create a hashmap containing all alphabet in string t with its frequency
// set a target with t.length to track whether the condition is satisfied
// set a start index at 0, create a for loop at with end at 0
// put every character with its frequency in the hashmap, with value -1
// if the frequency in the hashmap?>0, then target --
// if target == 0, means we found a valid substring, then we need to move start forward to remove unecessary string
// start ++, with frequency++, until when map.contains start and freq == 0, means we reach the character in string t
// then we stop and update the minimum substring index
// then start++, frequency++, and continue with end--, frequency--