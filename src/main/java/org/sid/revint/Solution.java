package org.sid.revint;

public class Solution {

    public int reverse(int x) {


            boolean neg = x <0;
            if (neg) {
                x *= -1;
            }

            long res =0;
            while (x != 0) {
                int rem = x%10;
                x /= 10;
                res = res*10 + rem;
            }
            if ( neg ) {
                res *= -1;
            }
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            return (int)res;
    }

}
