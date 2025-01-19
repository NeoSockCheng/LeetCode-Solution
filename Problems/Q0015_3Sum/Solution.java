package Problems.Q0015_3Sum;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if (total == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                } else if (total < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}

// question: given an array of integer, find out three element that sum up to be zero
// solution: loop array as i, and then use j and k as two pointer to add up with i
// if sum is zero, add to result j++; if sum>0 k--; if sume<0 j++
// remember to handle duplicate cases, by ensuring element i!=i-1, j!=j-1
    