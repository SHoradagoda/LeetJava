package org.sid.longestPalindrome;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome ( "cbbd"));
    }

    private String longestPalindrome(String string) {
        if ( string.length() < 2) {
            return string;
        }

        int longestPalindromeLen = 0;
        int start = 0;
        int end = 0;
        char[] charArr = string.toCharArray();
        for ( int i=0;i<=charArr.length;i++) {
            for (int j=charArr.length -1;j>i && j-i > longestPalindromeLen;j--) {
                if (isPal(charArr, i, j) ){
                    longestPalindromeLen = j-i;
                    start =i;
                    end = j;
                }
            }

        }
        return new String (Arrays.copyOfRange(charArr, start, end+1));
    }

    private boolean isPal(char[] s, int start, int end) {
        System.out.println("Checking " + new String (Arrays.copyOfRange(s, start, end+1)));
        int len =  end - start +1;
        if ( len < 2) {
            return true;
        }
        for ( int i=0;i<len/2;i++) {
            if ( s[start + i] != s[end-i]) {
                return false;
            }
        }
        return true;
    }
}
