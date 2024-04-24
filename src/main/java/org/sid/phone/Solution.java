package org.sid.phone;

import java.util.*;
import java.util.stream.Collectors;
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
        if ( digits.length() == 0) {
            return List.of();
        }
        List<String> results = new ArrayList<>();
        backTrack("", digits, results);
        return results;
    }

    void backTrack ( String head, String tail, List<String> results ){
        if (tail.length() ==0){
            results.add(head);
            return;
        }
        List<String> first = Stream.of( mapping.get(tail.charAt(0))).map(x -> head + x).collect(Collectors.toList());
        for ( String f : first) {
            backTrack(f, tail.substring(1), results);
        }
    }

}