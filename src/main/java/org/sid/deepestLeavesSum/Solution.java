package org.sid.deepestLeavesSum;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public int deepestLeavesSum(TreeNode root) {

        int maxDepth = findDeepestLevelValue(0, root);
        AtomicInteger deepestLevelSum = new AtomicInteger();
        addValues(deepestLevelSum, maxDepth, 0, root);
        return deepestLevelSum.get();
    }

    private void addValues(AtomicInteger deepestLevelSum, int maxDepth, int curr, TreeNode node) {
        if (node == null) {
            return;
        }
        if (maxDepth == curr) {
            deepestLevelSum.addAndGet(node.val);
            return;
        }
        addValues(deepestLevelSum, maxDepth, curr + 1, node.left);
        addValues(deepestLevelSum, maxDepth, curr + 1, node.right);
    }

    private int findDeepestLevelValue(int currDepth, TreeNode node) {

        int leftDepth = node.left == null ? currDepth: findDeepestLevelValue(currDepth + 1, node.left);
        int rightDepth = node.left == null ? currDepth: findDeepestLevelValue(currDepth + 1, node.right);
        return Integer.max(leftDepth, rightDepth);

    }

    public static void main(String[] args) {
        new Solution().deepestLeavesSum(new TreeNode(5, new TreeNode(4), new TreeNode(6)));
    }
}

//      Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


