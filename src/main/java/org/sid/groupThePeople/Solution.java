package org.sid.groupThePeople;

import java.util.*;

public class Solution {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        Map<Integer, List<Integer>> groupSizeToMemberMap = new LinkedHashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            var currentItem = groupSizes[i];
            var currList = groupSizeToMemberMap.get(currentItem);
            if (currList == null) {
                currList = new ArrayList<>(currentItem);
                groupSizeToMemberMap.put(currentItem, currList);
            }
            currList.add(currentItem);
            if (currList.size() == currentItem) {
                groupSizeToMemberMap.remove(currentItem);
                ans.add(currList);
            }
        }
        return ans;
    }


    public List<List<Integer>> groupThePeople2(int[] groupSizes) {

        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();


        for (int i = 0; i < groupSizes.length; i++) {

            if (!mp.containsKey(groupSizes[i])) {
                mp.put(groupSizes[i], new ArrayList<Integer>());
            }
            mp.get(groupSizes[i]).add(i);

        }

        for (int s : mp.keySet()) {

            int size = mp.get(s).size() / s;
            for (int i = 0; i < size; i++) {

                int start = 0;

                List<Integer> temp = new ArrayList<>();

                for (; start < s; start++) {

                    temp.add(mp.get(s).get(start));

                }

                ans.add(temp);

            }


        }

        return ans;

    }

    public static void main(String[] args) {
        groupThePeople(new int[]{2, 3, 2, 2, 3, 3, 2});
    }
}
