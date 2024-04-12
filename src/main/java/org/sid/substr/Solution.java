package org.sid.substr;

public class Solution {
    final static int[] slots = new int[128];
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if ( len < 2) {
            return len;
        }

        int leftPointer = 0;
        int rightPointer = 1;
        int max = 1;

        while ( rightPointer > leftPointer && rightPointer < len){
            if ( isNonRepeating(s, leftPointer, rightPointer)) {
                max = Math.max(max, 1+rightPointer - leftPointer);
                rightPointer++;
            }else {
                leftPointer++;
                if ( leftPointer == rightPointer ) {
                    rightPointer++;
                }
            }
        }
        return max;
    }

    static boolean isNonRepeating(String s, int leftPointer, int rightPointer) {
        for ( int i=0;i<128;i++) {
            slots[i] =0;
        }
        for ( int i=leftPointer;i<=rightPointer;i++){
            slots[(int)s.charAt(i)]++;
        }
        for ( int i=0;i<128;i++) {
            if (slots[i] > 1) {
                return false;
            }
        }
        return true;
    }
}