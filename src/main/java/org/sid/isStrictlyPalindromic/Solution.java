package org.sid.isStrictlyPalindromic;

public class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for ( int i=2;i<n-1;i++) {
            if (!isStrictlyPalindromic(i, n)) {
                return false;
            }
        }
        return true;
    }
    private boolean isStrictlyPalindromic(int base, int n) {
        String basedNumber = Integer.toString(n, base);
        return isPalindrome(basedNumber);
    }

    private boolean isPalindrome(String basedNumber) {
        for (int i =0, j=basedNumber.length() - 1;i<j;i++,j--){
            if ( basedNumber.charAt(i) != basedNumber.charAt(j) ) {
                return false;
            }
        }
        return true;
    }

    private String getBasedNumber ( int base, int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int remainder = n % base;
            sb.append(remainder);
            n = n / base;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().isStrictlyPalindromic(9);
    }

}