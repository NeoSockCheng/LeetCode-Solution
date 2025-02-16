package Problems.Q0239_Sliding_Window_Maximum;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public  int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            while (!deque.isEmpty() && deque.getLast() < num) {
                deque.pollLast();
            }
            deque.addLast(num);

            if (i >= k && nums[i - k] == deque.getFirst()) {
                deque.pollFirst();
            }

            if (i >= k - 1) {
                res.add(deque.getFirst());
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

}

// Question: maxmimum number in the sliding window with fixed length k
// Solution: use a deque to store the index of the elements in the window, and always keep
// the largest element in the front of the deque. When the window moves, remove the elements
// that are out of the window from the back of the deque. The maximum element in the window
// is the front element of the deque. Time complexity: O(n), space complexity: O(n