package org.sid.mergeNodes;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode();
        ListNode resultCursor = result;
        head = head.next;

        while (head.next != null) {
            if (head.val == 0) {
                resultCursor.next = new ListNode();
                resultCursor = resultCursor.next;
            } else {
                resultCursor.val += head.val;
            }
            head = head.next;
        }
        return result;
    }

}