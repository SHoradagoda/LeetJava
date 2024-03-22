package org.sid.reverseInt;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        var x = new Solution();
        Arrays.asList(1234, 321, -1234, Integer.MAX_VALUE, Integer.MIN_VALUE).forEach( l -> System.out.println(l + "->" + x.reverse(l)));

    }
    public int reverse(int x) {
        boolean negative = x < 0;
        String str = Integer.toString(Math.abs(x));
        String rev = "";
        for ( int i = 0;i<str.length();i++) {
            rev = str.charAt(i)+ rev;
        }
        long longVal = Long.parseLong(rev) * (negative ? -1 :1);
        if ( negative && longVal < Integer.MIN_VALUE) {
            return 0;
        }
        if ( longVal > Integer.MAX_VALUE){
            return 0;
        }
        return ((int)longVal);
    }
}