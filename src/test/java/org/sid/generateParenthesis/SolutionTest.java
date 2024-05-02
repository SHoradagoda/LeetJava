package org.sid.generateParenthesis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void check() {
        new Solution().generateParenthesis(3).forEach(System.out::println);
    }
}