package Template;

import java.util.Arrays;

public class TwoPointers {
    public static boolean hasPairWithSum(int[] arr, int target) {
        // Sort the array to use two pointers technique
        Arrays.sort(arr);

        // Initialize two pointers
        int left = 0;
        int right = arr.length - 1;

        // Iterate with two pointers
        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                return true; // Pair found
            } else if (currentSum < target) {
                left++; // Increment left pointer to increase the sum
            } else {
                right--; // Decrement right pointer to decrease the sum
            }
        }

        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 6, 8, 10 };
        int target = 10;

        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair with sum " + target + " exists.");
        } else {
            System.out.println("No pair with sum " + target + " found.");
        }
    }
}

/*
 * Time complexity: O(n)
 * usecase: palindrome, finding two numbers sums up to specific total, merge sorted array, reverse array, remove duplicates
 * edge case: empty array, single element, equal values, unsorted array, multiple valid solution, negative numbers
 */
