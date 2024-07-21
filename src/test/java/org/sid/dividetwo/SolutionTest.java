package org.sid.dividetwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution s = new Solution();
    @Test
    public void div() {
        assertEquals ( -2, s.divide(-7, 3));
        assertEquals ( 2, s.divide(7, 3));
        assertEquals ( 3, s.divide(10, 3));
        assertEquals ( Integer.MAX_VALUE, s.divide(Integer.MAX_VALUE, 1));
    }
}