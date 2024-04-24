package org.sid.remoteNthNodeTwoPointer;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(1, head);
        ListNode rightPointer = dummy, leftPointer = dummy;

        while ( n > -1) {
            rightPointer = rightPointer.next;
            n--;
        }
        while ( rightPointer != null){
            leftPointer = leftPointer.next;
            rightPointer = rightPointer.next;
        }
        leftPointer.next = leftPointer.next.next;
        return dummy.next;
    }
}