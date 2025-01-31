package Template;

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid overflow

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

}

/*
 * Only works on SORTED DATA
 * Time Complexity: O(log n)
 * Use case: sorted array, rotated array, search ranges, matrices
 * Edge case: empty array, unfound target value, duplicate value
 */
