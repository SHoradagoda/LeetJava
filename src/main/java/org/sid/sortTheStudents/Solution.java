package org.sid.sortTheStudents;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[][] sortTheStudents(int[][] score, int k) {

        Arrays.sort(score, 0, score.length, Comparator.comparingInt(s -> s[k]));
        return score;
    }

}
