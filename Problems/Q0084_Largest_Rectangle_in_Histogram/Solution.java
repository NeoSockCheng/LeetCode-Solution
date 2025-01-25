package Problems.Q0084_Largest_Rectangle_in_Histogram;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){
            while(stack.peek() != -1 && heights[i] <= heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while(stack.peek() != -1){
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}

/*
    Question: Given an array of bar heights representing a histogram, 
    find the area of the largest rectangle that can be formed within the histogram.

    Answer: Use a monotonic stack to efficiently calculate the largest rectangle by 
    finding the width for each bar based on its next and previous smaller heights

 */