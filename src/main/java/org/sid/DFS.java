package org.sid;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void visit(int value) {
        System.out.print(value + " ");
    }


    public static void traverseDepth(Node node) {
        if (node != null) {
            System.out.println(node.value);
            traverseDepth(node.left);
            traverseDepth(node.right);
        }
    }

    public static void traversePreOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node != null) {
                visit(node.value);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
    }

    public static void traverseBreadth(Node node) {
        List<Node> list = new LinkedList<>();
        list.add(node);
        while (!list.isEmpty()) {
            node = list.remove(0);
            visit(node.value);
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        // creating a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // traversing the tree in pre-order
        traverseDepth(root);
    }
}