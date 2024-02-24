package org.sid.maxsubarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSubArray {

    private static int[] maxFromIndex;
    private static List<List<Integer>> maxSubArray;

    public static void main(String[] args) {
        List<Integer> list = List.of(1, -3, 5, -1, 4, 5, -7, 2, -19, 1);
        maxFromIndex = new int[list.size()];
         maxSubArray = new ArrayList<>(list.size());
        System.out.println(Arrays.toString(maxSubArray(list)));
    }

    private static int[] maxSubArray(List<Integer> list) {
        if (list.isEmpty()) {
            return new int[]{};
        }
        if (list.size() == 1) {
            return new int[]{0};
        }
        maxFromIndex[0] = list.get(0);
        maxSubArray.add( List.of(maxFromIndex[0]));
        int maxIndexPos = 0;
        int maxIndex = maxFromIndex[0];

        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            int currentWithPrev = maxFromIndex[i - 1] + current;
            List<Integer> currencList = new ArrayList<>();
            if (currentWithPrev > current) {
                currencList.addAll(maxSubArray.get(i - 1));
                maxFromIndex[i] = currentWithPrev;
            } else {
                maxFromIndex[i] = current;
            }
            currencList.add(current);
            maxSubArray.add(currencList);
            if (maxFromIndex[i] > maxIndex) {
                maxIndex = maxFromIndex[i];
                maxIndexPos = i;
            }
        }
        return maxSubArray.get(maxIndexPos).stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
