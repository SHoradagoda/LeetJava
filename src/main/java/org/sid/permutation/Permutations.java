package org.sid.permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {
    public static void main(String[] args) {
        printPermutations ( 4, 3);
    }

    private static void printPermutations(int elements, int slots) {
        List<Integer> str = IntStream.range(1,elements+1).boxed().collect(Collectors.toList());
        generatePermutations( new ArrayList<>(), str, slots, 0);
    }

    private static void generatePermutations(List<Integer> current, List<Integer> options, int slots, int index) {

        if ( index == slots ) {
            System.out.println(current);
        }
        else {
            for ( Integer op : options) {
                List<Integer> next = new ArrayList<>(current);
                next.add(op);
                generatePermutations(next, options, slots, index + 1);
            }
        }

    }
}
