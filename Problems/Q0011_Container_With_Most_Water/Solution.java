package Problems.Q0011_Container_With_Most_Water;

class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            int currentArea = Math.min(height[i], height[j]) * (j-i);
            maxArea = Math.max(currentArea, maxArea);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    }
}

// Question: given an array of height, find out the maximum area of water contained (x as base, min height as y)
// SOlution: 2 pointer apporach, if (right-left) * min(left,right) >maxArea, maxArea = current area
// else (left>right)? right--: left++;