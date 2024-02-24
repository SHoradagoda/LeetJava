package org.sid;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        insertSort(1, 2, 4, 5, 3, 2);
    }

    private static void insertSort(int... vars) {
        for (int i = 1; i < vars.length; i++) {
            int key = vars[i];
            int newLoc = i - 1;
            while (newLoc >= 0 && vars[newLoc] > key) {
                vars[newLoc + 1] = vars[newLoc];
                newLoc--;
            }

            vars[newLoc + 1] = key;
        }
        IntStream.of(vars).forEach(System.out::println);
    }
}