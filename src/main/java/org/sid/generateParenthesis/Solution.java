package org.sid.generateParenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    private final Stack<Character> characterStack = new Stack<>();
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrack(0, 0, n, list);
        return list;
    }

    private void backTrack(int openN, int closeN, int n,  List<String> list) {
//        var x = new StringBuilder();
//        characterStack.stream().forEach(c -> x.append(c));
//        String str = x.toString();
//
//        System.out.println(openN + " " + closeN+ " "+str);
        if (closeN == openN && openN == n) {
            var x = new StringBuilder();
            characterStack.stream().forEach(c -> x.append(c));
            list.add(x.toString());
            return;
        }

        if (openN < n) {
            openN++;
            characterStack.push('(');
            backTrack(openN, closeN, n,  list);
            characterStack.pop();
            openN--;
        }
        if (closeN < openN) {

            closeN++;
            characterStack.push(')');
            backTrack(openN, closeN, n,  list);
            characterStack.pop();
            closeN--;

            }

    }
}

