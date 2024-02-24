package org.sid.deepestLeavesSum;


public class Sol2 {

    int maxDepth = 0;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        sum = root.val;
        deepestLeaveSum(root.left,1);
        deepestLeaveSum(root.right,1);
        return sum;
    }

    private void deepestLeaveSum ( TreeNode node, int depth) {
        if ( node == null) {
            return;
        }
        if ( depth > maxDepth) {
            sum = node.val;
            maxDepth = depth;
        }
        else if ( depth == maxDepth) {
            sum += node.val;
        }
        deepestLeaveSum(node.left, depth+1);
        deepestLeaveSum(node.right, depth+1);
    }

    public static void main(String[] args) {
        System.out.println(new Sol2().deepestLeavesSum(new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(5), null ),
                new TreeNode(6,
                        new TreeNode(5), null )
                )));
    }
}
//      Definition for a binary tree node.
