package org.sid;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 4;
        var numbers = new ArrayList<>(4);
        while ( count > 0) {
            numbers.add(in.nextInt());
            count--;
        }

        System.out.println(numbers);
    }

    private static List<Integer> quickSort ( List<Integer> list) {
        Integer first = list.get(0);
        List<Integer> lower = list.stream().filter(i -> i < first).collect(Collectors.toList());
        List<Integer> greater = list.stream().filter(i -> i > first).collect(Collectors.toList());
        var output = quickSort(lower);
        output.add(first);
        output.addAll(quickSort(greater));
        return output;
    }
}
