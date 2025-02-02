package Problems.Q0567_Permutation_in_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (char c : s1.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }

//         int left = 0;
//         int n = s2.length();
//         int m = s1.length();
//         for (int right = 0; right < n; right++) {
//             char c = s2.charAt(right);
//             if (map.containsKey(c) && map.get(c) > 0) {
//                 map.put(c, map.get(c) - 1);
//             } else if (!map.containsKey(c)) {
//                 while (left != right) {
//                     char d = s2.charAt(left);
//                     map.put(d, map.get(d) + 1);
//                     left++;
//                 }
//                 left = right + 1;
//             } else {
//                 while (map.get(c) <= 0) {
//                     char d = s2.charAt(left);
//                     map.put(d, map.get(d) + 1);
//                     left++;
//                 }
//                 map.put(c, map.get(c) - 1);
//             }
            
//             if (right - left + 1 == m) {
//                 return true;
//             }
            
//         }
//         return false;
//     }
// }

// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int[] arr = new int[26];
//         Arrays.fill(arr, -1);
//         for (char c : s1.toCharArray()) {
//             int d = (int) (c) - 'a';
//             if(arr[d]==-1){
//                 arr[d] += 2;
//             } else {
//                 arr[d]++;
//             }
//         }

//         int left = 0;
//         int n = s2.length();
//         int m = s1.length();
//         for (int right = 0; right < n; right++) {
//             int c = (int)s2.charAt(right)-'a';
//             if (arr[c] > 0) {
//                 arr[c]--;
//             } else if (arr[c] == -1) {
//                 while (left != right) {
//                     int d = (int)s2.charAt(left)-'a';
//                     arr[d]++;
//                     left++;
//                 }
//                 left = right + 1;
//             } else {
//                 while (arr[c] <= 0) {
//                     int d = (int) s2.charAt(left) - 'a';
//                     arr[d]++;
//                     left++;
//                 }
//                 arr[c]--;
//             }

//             if (right - left + 1 == m) {
//                 return true;
//             }
            
//         }
//         return false;
//     }
// }

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m > n) {
            return false;
        }

        HashMap<Character, Integer> s1map = new HashMap<>();
        HashMap<Character, Integer> s2map = new HashMap<>();


        for (int i = 0; i < m; i++) {
            char c = s1.charAt(i);
            char d = s2.charAt(i);
            s1map.put(c, s1map.getOrDefault(c, 0) + 1);
            s2map.put(d, s2map.getOrDefault(d, 0) + 1);
        }
        if (s1map.equals(s2map)) {
            return true;
        }

        int left = 0;
        for (int right = m; right < n; right++) {
            char c = s2.charAt(right);
            s2map.put(c, s2map.getOrDefault(c, 0) + 1);

            char d = s2.charAt(left);
            s2map.put(d, s2map.get(d) - 1);
            if (s2map.get(d) == 0) {
                s2map.remove(d);
            }

            left++;

            if (s1map.equals(s2map)) {
                return true;
            }

        }
        return false;
    }
}

// Question: find if s1's permutation exist in s2
// Solution: two pointer or sliding window
// sliding window - initialize hashmap for each string with s1.length
// move the window to the right and check is both hashmap equals