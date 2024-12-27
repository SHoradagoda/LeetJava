package org.sid.swapInLL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode( 2, a);
    ListNode c = new ListNode( 3, b);
    ListNode d = new ListNode( 4, c);
    @BeforeEach
    public void init(){
        a = new ListNode(1);
        b = new ListNode( 2, a);
        c = new ListNode( 3, b);
        d = new ListNode( 4, c);
    }

    @Test
    public void test1() {
        new Solution().swapPairs(d);

        assertEquals(3, d.val);
        assertEquals(4, c.val);
        assertEquals(1, b.val);
        assertEquals(2, a.val);
    }


}