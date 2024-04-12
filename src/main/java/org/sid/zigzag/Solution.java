package org.sid.zigzag;

public class Solution {
    /**
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     */
    public String convert(String s, int numRows) {
        /*
            N = 3
            Row 1 : 0, 4, 8, 12
            Row 2 : 1,3 5,7,
         */
        /**
         * N = 4
         * P     I    N
         * A   L S  I G
         * Y A   H R
         * P     I
         *
         * Row 1 : 0 ,  6 ,  12
         * Row 2 : 1,   5,7   11,13
         * Row 3 : 2,4 8,10
         * Row 4:  3, 9
         */

        /**
         * 0    8
         * 1   79
         * 2  6 0
         * 3 5  1
         * 4    2
         */

        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        int counter =0;
        for ( int i=0;i<numRows;i++){
            for ( int j=0;j<chars.length;j++) {
                if ( belongs(i, j)) {
                    result[counter++] = chars[j];
                }
            }
        }
        return new String(result);
    }

    private boolean belongs(int row, int index) {

        int x = 2*row -2;
        //Row 0
        if ( row == 0) {
            return index % x == row;
        }
        //Row 1

        return (index  % x == row) || (index + row + 1) % x == row ;
    }
}
