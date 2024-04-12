package org.sid.closest3;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closest = (target > 0 ? Integer.MIN_VALUE: Integer.MAX_VALUE) ;
        long dist = Integer.MAX_VALUE;

        for ( int leftIndex=0;leftIndex<nums.length;) {
            int leftval = nums[leftIndex];
            int midIndex = leftIndex+1;
            int rightIndex = nums.length -1;
            while ( rightIndex > midIndex) {
                int sum = leftval + nums[midIndex] + nums[rightIndex];
                long newDist = Math.abs(sum - target);
                if ( newDist < dist ){
                    dist = newDist;
                    closest = sum;
                }
                if ( sum > target) {
                    rightIndex--;
                }else{
                    midIndex++;
                }
            }
            while (leftIndex<nums.length && leftval == nums[leftIndex]){
                leftIndex++;
            }
        }
        return closest;
    }
}