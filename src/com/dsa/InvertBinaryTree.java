/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
package com.dsa;

import com.dsa.structures.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode newRoot = invertTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
        return root;
    }
}
