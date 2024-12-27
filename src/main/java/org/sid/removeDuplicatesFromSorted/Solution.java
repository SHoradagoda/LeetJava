package org.sid.removeDuplicatesFromSorted;

public class Solution {
    public int removeDuplicates(int[] nums) {

            if (nums.length < 2) {
                return 1;
            }
            int cursor = 1;
            int last = nums[0];
            int uniques = nums.length;
            for (int i =1;i< nums.length;i++) {
                if ( last == nums[i]) {
                    uniques--;
                    continue;
                }
                last = nums[i];
                nums[cursor++] = nums[i];
            }
            return uniques;
    }
}
