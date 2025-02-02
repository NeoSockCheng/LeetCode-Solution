package Problems.Q0003_Longest_Substring_Without_Repeating_Characters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n = s.length();
//         int maxLength = 0;
//         int left = 0;
//         Set<Character> set = new HashSet<>();
//         for (int right = 0; right < n; right++) {
//             char curr = s.charAt(right);
//             if (set.contains(curr)) {
//                 while (set.contains(curr)) {
//                     set.remove(s.charAt(left));
//                     left++;
//                 }
//             } else {
//                 maxLength = Math.max(maxLength, right - left + 1);
//             }
//             set.add(curr);
//         }
//         return maxLength;
//     }
// }


// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n = s.length();
//         int maxLength = 0;
//         int left = 0;
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (int right = 0; right < n; right++) {
//             char c = s.charAt(right);
//             if (map.containsKey(c) && map.get(c) >= left) {
//                 left = map.get(c) + 1;
//             } else {
//                 maxLength = Math.max(maxLength, right - left + 1);
//             }
//             map.put(c, right);
//         }
//         return maxLength;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int[] array = new int[128];
        Arrays.fill(array, -1);

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (array[(int)c] >= left) {
                left = array[(int)c] + 1;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            array[(int) c] = right;
        }
        return maxLength;
    }
}

// Question: find the longest substring in a string without repeating characters
// solution: sliding window with set/hashmap/array. array performs the fastest
// initialize a left pointer, a keep increasing right pointer, and a maxlength
// set - put char in the set, until current char exist in the set, then eliminate the char until current char removed
// hashmap/array - put char in the hashmap, until current char exist in the hashmap, then update the left pointer to current char ori index + 1
// update maxlength and char in array