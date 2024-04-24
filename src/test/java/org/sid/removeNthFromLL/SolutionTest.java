package org.sid.removeNthFromLL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void removeNth(){
        int[] all = new int[]{2};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for ( int i : all){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        new Solution().removeNthFromEnd(head, 2);
    }
}