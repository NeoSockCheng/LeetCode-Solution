package Problems.Q0033_Search_in_Rotated_Sorted_Array;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println(mid);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

// Question: search a number in a rotated ascending array
// Answer: use binary search. if current value greater than left value, then check if the target is betweeen left and curr
// if current value smaller than right value, then check if the target is between curr and right
// and move pointer to each direction respectively