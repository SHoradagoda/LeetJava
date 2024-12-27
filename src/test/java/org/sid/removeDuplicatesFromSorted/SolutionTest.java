package org.sid.removeDuplicatesFromSorted;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();
    @Test
    public void test1(){
        int[] ints = new int[]{1, 2, 2, 3};
        int result = solution.removeDuplicates(ints);
        assertEquals(3, result);
        assertArrayEquals(new int[]{1,2,3,3}, ints);
    }
}