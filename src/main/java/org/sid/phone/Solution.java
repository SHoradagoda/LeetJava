package org.sid.phone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Solution {

    Map<Character, Character[]> mapping = new HashMap<>() {{
       put('2', new Character[]{'a', 'b','c'});
        put('3', new Character[]{'d', 'e','f'});
        put('4', new Character[]{'g', 'h','i'});
        put('5', new Character[]{'j', 'k','l'});
        put('6', new Character[]{'m', 'n','o'});
        put('7', new Character[]{'p', 'q','r', 's'});
        put('8', new Character[]{'t','u', 'v'});
        put('9', new Character[]{'w', 'x','y', 'z'});
    }};
    public List<String> letterCombinations(String digits) {

        char[] chars = digits.toCharArray();
        if ( chars.length == 1) {
            return Stream.of(mapping.get(chars[0]))
        }
        for (int i=0;i< chars.length;i++) {
            Character[] first = mapping.get (chars[i]);
            for (int j=i+1;j < chars.length;j++) {
                Char
            }
        }
        return null;
    }

}