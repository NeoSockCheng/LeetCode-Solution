package Template;

public class SlidingWindow {
    public int maxSumSubarray(int[] nums, int k) {
        int maxSum = 0, currentSum = 0;
        int start = 0;

        // Iterate through the array
        for (int end = 0; end < nums.length; end++) {
            // Add the next element to the current window
            currentSum += nums[end];

            // Shrink the window when its size exceeds k
            if (end - start + 1 > k) {
                currentSum -= nums[start]; // Remove the element at `start`
                start++; // Slide the window forward
            }

            // Update the max sum if the window size is exactly k
            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}

