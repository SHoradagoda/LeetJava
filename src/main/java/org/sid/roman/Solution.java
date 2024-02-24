package org.sid.roman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final static Map<Integer, Character> SEQUENCE = new HashMap<>(){{
        put(1,'I');
        put(5,'V');
        put(10,'X');
        put(50,'L');
        put(100,'C');
        put(500,'D');
        put(1000,'M');
    }};
    public String intToRoman(int num) {
        final char[] output = new char[20];
        int index = 20;
        int cursor = num;
        char ones = 'I';
        char fives = 'V';
        char tens = 'X';
        int base = 1;
        while (cursor != 0) {
            int last = cursor % 10;
            switch (last) {
                case 1:
                    output[index--] = ones;
                    break;
                case 2:
                    output[index--] = ones;
                    output[index--] = ones;
                    break;
                case 3:
                    output[index--] = ones;
                    output[index--] = ones;
                    output[index--] = ones;
                    break;
                case 4:
                    output[index--] = fives;
                    output[index--] = ones;
                    break;
                case 5:
                    output[index--] = fives;
                    break;
 /*               case 6:
                case 7:
                case 8:
                    output.insert(0,fives + ones.repeat(last-5));
                    break;
                case 9:
                    output.insert(0,ones+tens);
                    break;*/
            }
            cursor = cursor/10;
            base = base*10;
            ones = SEQUENCE.get(base);
            fives = SEQUENCE.get(base*5);
            tens = SEQUENCE.get(base*10);
        }
        return Arrays.copyOfRange(output, index, 10).toString();
    }

    public static void main(String[] args) {
        long start =0;
        Solution s = new Solution();
        while ( start++ < 1_000_000){
            s.intToRoman((int)(Math.random()*4000));
        }
//        Integer[] tests = new Integer[]{1, 9, 12, 10, 15, 19, 22,49,57,99};
//        Arrays.asList(tests).forEach(t -> System.out.println(t + " -> " + new Solution().intToRoman(t)));
    }
}