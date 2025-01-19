package Problems.Q0167_Two_Sum_II;


class Solution {
    // public int[] twoSum(int[] numbers, int target) {
    //     int start = 0;
    //     int end = numbers.length -1;
    //     while (true) {
    //         if (numbers[start] + numbers[end] > target) {
    //             end--;
    //         } else if (numbers[start] + numbers[end] < target) {
    //             start++;
    //         } else {
    //             break;
    //         }
    //     }
    //     return new int[] { ++start, ++end };
    // }

    /*
     * this question provided an array of integers and a target, we need to find out the two numbers that can sum up to form the targtt
     * basically we will use two pointer approach, start from the left and right of the array, when sume<target, start++, if sum>target, end--
     * improved area: improve performance and shorten code
     */
    
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left < right) {
            int total = numbers[left] + numbers[right];
            if (total == target) {
                return new int[] { ++left, ++right };
            } else if (total < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1,-1};
    }
}