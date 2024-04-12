package org.sid.threesum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Pair> pairs = new ArrayList<>();
        for ( int i =0;i<nums.length-1;i++) {
            for ( int j=i+1;j < nums.length;j++){
                pairs.add(p(nums, i, j));
            }
        }
        Map<Integer, List<Integer>> indexValues = new HashMap<>();
        for ( int i =0;i<nums.length;i++) {
            int val = nums[i];
            indexValues.computeIfAbsent(val, v -> new ArrayList<>()).add(i);
        }
        List<List<Integer>> results = new ArrayList<>();
        for ( Pair p : pairs ){
            List<Integer> matches = indexValues.get(-p.sum);
            if ( matches != null) {
                matches.removeAll(p.indexes);
                for ( Integer match : matches ) {
                    List<Integer> next = new ArrayList<>(){{addAll(p.values);}};
                    next.add(nums[match]);
                    results.add(next);
                }
            }
        }
        return results;
    }

    private Pair p(int[] nums, int lIndex, int rIndex) {
        Pair p = new Pair();
        int lValue = nums[lIndex];
        int rValue = nums[rIndex];

        p.values = new ArrayList<>(){{add(lValue);add(rValue);}};
        p.indexes = new ArrayList<>(){{add(lIndex);add(rIndex);}};
        p.sum = lValue + rValue;
        return p;
    }
    class Pair{
        List<Integer> values;
        List<Integer> indexes;
        int sum;

    }
}