package Problems.Q0424_Longest_Repeating_Character_Replacement;

class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int res = 0;
        int max = 0;
        int left = 0;
        int n = s.length();

        for (int right = 0; right < n; right++) {
            int c = s.charAt(right) - 'A';
            arr[c]++;
            max = Math.max(max, arr[c]);

            if (right - left + 1 - max > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            else {
                res = Math.max(res, right - left + 1);
            }

        }
        return res;

    }
}