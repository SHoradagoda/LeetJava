package org.sid.pivotArray;

public class Solution {
    public static int[] pivotArray(int[] nums, int pivot) {

        int val, nextVal, prevVal;
        for ( int i = 0;i< nums.length ;i ++) {
            val = nums[i];
            if (val > pivot) {
                for ( int j = i+1 ;j < nums.length;j++) {
                    nextVal = nums[j];
                    if ( nextVal <= pivot) {
                        //swap
                        nums[j-1] = nextVal;
                        nums[j] = val;
                        i =0;
                    }else{
                        break;
                    }
                }
            }else if ( val < pivot) {
                for ( int j= i-1; j > 0 ;j --) {
                    prevVal = nums[j];
                    if ( prevVal >= pivot ){
                        //swap
                        nums[j+1] = prevVal;
                        nums[j] = val;
                        i =0;
                    }else {
                        break;
                    }
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        pivotArray(new int[]{9,12,5,10,14,3,10}, 10);
    }
}
