package Problems.Q0287_Find_the_Duplicate_Number;

import java.util.Arrays;
import java.util.HashSet;

// set
// class Solution {
//     public int findDuplicate(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();

//         for (int i : nums) {
//             if (!set.add(nums[i])) {
//                 return i;
//             } 
//         }
//         return -1;
//     }
// }

// arrays.sort
// class Solution {
//     public int findDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] == nums[i-1]) {
//                 return nums[i];
//             }
//             prev = nums[i];
//         }
//         return -1;
//     }
// }

// Floyd tortoise and Hare algorithm (detect cycle in linkedlist)
class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;

        do{ 
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

/*
Question: Given an array of n+1 integers where each number is in the range [1, n], find the duplicate number without modifying the array and using constant extra space.

Solution: Use Floyd’s Cycle Detection Algorithm by treating the array as a linked list where each index points to nums[i], detecting a cycle to find the duplicate.

Steps:
Use two pointers (slow moves one step, fast moves two steps) to detect a cycle in the number sequence.
Once slow and fast meet, reset slow to 0 and move both one step at a time until they meet again.
The meeting point is the duplicate number.
 *
 */