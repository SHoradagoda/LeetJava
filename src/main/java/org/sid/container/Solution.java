package org.sid.container;
class Solution {
    public int maxArea(int[] height) {

        if ( height.length < 2)
            return 0;

        int left = 0;
        int right = height.length -1;
        int maxArea = 0;
        while ( left < right) {
            int lh = height[left];
            int rh = height[right];
            int minH = Math.min(lh, rh);
            int width = right - left;
            maxArea = Math.max(maxArea, minH*width);
            if ( lh < rh) {
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}