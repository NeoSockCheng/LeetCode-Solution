package Problems.Q875_Koko_Eating_Bananas;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] piles = {805306368, 805306368, 805306368};
        System.out.println("result: " + minEatingSpeed(piles, 1000000000));
    }

        public static int minEatingSpeed(int[] piles, int h) {
            int low = 1; // Minimum possible eating speed
            int high = Arrays.stream(piles).max().getAsInt(); // Maximum pile size
            int res = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2; // Prevent overflow
                if (canEatAll(piles, mid, h) <= 0) { // Koko can finish within h hours
                    res = mid;
                    high = mid - 1; // Try for smaller speed
                } else {
                    low = mid + 1; // Try for larger speed
                }
            }

            return res;
        }

        private static int canEatAll(int[] piles, int num, int h) {
            int time = 0;
            for (int i : piles) {
                time += i / num;
                if (i % num != 0) {
                    time++;
                }
                if (time > h) { // If time exceeds h, no need to continue
                    return 1;
                }
            }
            return time <= h ? 0 : 1;
        }
}

// Question: given array of number of bananas, and time to finish them, find the least number of bananas for koko to eat per hour
// solution: use binary search, the answer must between lowest number and highest number of banana