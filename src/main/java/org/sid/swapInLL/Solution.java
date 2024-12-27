package org.sid.swapInLL;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      public String toString() {
          return String.valueOf(val);
      }
  }

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode cursor = head;
        ListNode swap = cursor.next;
        int temp;
        while ( swap != null) {
            temp = cursor.val;
            cursor.val = swap.val;
            swap.val = temp;
            cursor = swap.next;
            if ( cursor == null)
                break;
            swap = cursor.next;
        }
        return head;
    }
}