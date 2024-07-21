package org.sid.dividetwo;

class Solution {
    public int divide(int dividend, int divisor) {

        if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        return dividend / divisor;
    }
}
