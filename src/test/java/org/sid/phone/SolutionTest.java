package org.sid.phone;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void letters() {
        List<String> comb = new Solution().letterCombinations("23");
        System.out.println(comb);
    }
}