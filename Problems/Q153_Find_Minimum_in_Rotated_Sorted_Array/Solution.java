package Problems.Q153_Find_Minimum_in_Rotated_Sorted_Array;

// class Solution {

//     public int findMin(int[] nums) {
//         int left = 0;
//         int right = nums.length - 1;
//         int end = nums[right];
//         while (left <= right) {
//             int mid = (left + right) / 2;
//             System.out.println(mid);
//             if (mid < nums.length - 1) {
//                 if (nums[mid] > nums[mid + 1] && nums[mid] > end) {
//                     return nums[mid + 1];
//                 } else if (nums[mid] < end) {
//                     right = mid - 1;
//                 } else {
//                     left = mid + 1;
//                 }
//             }
//             else {
//                 break;
//             }
//         }
//         return nums[0];
//     }
// }

// Question: find minimum element in unsorted array with order like [4 5 6 1 2 3] (rotated)
// answer: use linear or binary search to find min, decide whether to go right or left by
// comparing current element with first/last element
// area improved: simplify the logic coz i think too complex ady

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (min > nums[mid]) {
                min = nums[mid];
            }
            if (nums[left] < nums[mid]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return min;

    }
}