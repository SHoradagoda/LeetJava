package org.sid.removeNthFromLL;


import java.util.List;

// Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cursor = head;
        int count =0;
        while (cursor != null) {
            cursor = cursor.next;
            count++;
        }
        if (n == count)
        {
            return head.next;
        }

        int node =count - n - 1;
        cursor = head;
        int current =0;
        while (cursor != null) {
            if ( current == node) {
                ListNode skipping = cursor.next;
                if ( skipping == null) // Delete last
                    cursor.next = null;
                else
                    cursor.next = skipping.next;
            }
            current++;
            cursor = cursor.next;
        }
        return head;
    }
}