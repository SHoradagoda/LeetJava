package org.sid.reverseLL;

public class Solution {

    public static void main(String[] args) {
        var l = new ListNode(1, new ListNode(2, new ListNode(3)));
        l = reverse (l);
        while ( l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    private static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        while ( curr != null ) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

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

    @Override
    public String toString() {
        return val +"";
    }
}