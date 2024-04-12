package org.sid.twosum;

import java.util.HashMap;
import java.util.Map;

class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> valIndexes = new HashMap();
            for ( int i =0;i<nums.length;i++) {
                int val = nums[i];
                Integer match = valIndexes.get(target - val);
                if ( match != null){
                    return new int[]{i, match};
                }
                valIndexes.put(val, i);
            }
            throw new RuntimeException("S");
        }
}
