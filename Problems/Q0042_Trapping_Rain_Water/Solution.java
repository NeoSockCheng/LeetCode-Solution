class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int totalArea = 0;

        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                totalArea += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                totalArea += maxRight - height[right];
            }

        }
        
        return totalArea;
    }
}

// Question: given an array of water height, find the water contained
// Solution: two pointer: find the max height of two side and during the way find the difference of height and maxheight