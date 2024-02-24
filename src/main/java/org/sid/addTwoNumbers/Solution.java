package org.sid.addTwoNumbers;

public class Solution {

    public static void main(String[] args) {
        new Solution().test();
    }

    private void test() {
        var l = addTwoNumbers(new ListNode(9),
                new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9)))));
//                        new ListNode(9, new ListNode(9,new ListNode(9,
//                                new ListNode(9, new ListNode(9, new ListNode(9)))))))))));
        while ( l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = new ListNode();
        int carryOver = 0;
        ListNode currentNode = output;
        while (true) {

            int currNode = l1 == null ? 0:l1.val;
            currNode += l2 == null ? 0:l2.val;
            currNode += carryOver;

            if( currNode > 9) {
                carryOver = 1;
                currNode -= 10;
            }else {
                carryOver = 0;
            }

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;

            currentNode.val = currNode;
            if ( l1 == null && l2 == null){
                if ( carryOver == 1) {
                    currentNode.next = new ListNode(1);
                }
                break;
            }
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
        }

        return output;
    }

    private long getIntValue(ListNode l1) {
        long sum = 0;
        int depth = 0;
        ListNode currentNode = l1;
        while ( currentNode != null ) {
            sum += Math.pow(10, depth++)* currentNode.val;
            currentNode = currentNode.next;
        }
        return sum;
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
    }
}
