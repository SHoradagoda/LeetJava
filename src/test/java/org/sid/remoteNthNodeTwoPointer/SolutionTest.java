package org.sid.remoteNthNodeTwoPointer;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void removeNth(){
        int[] all = new int[]{2,3,4,5,6};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for ( int i : all){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        new Solution().removeNthFromEnd(head, 2);
    }
}