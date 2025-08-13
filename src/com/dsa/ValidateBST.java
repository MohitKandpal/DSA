/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys strictly less than the node's key.
 * The right subtree of a node contains only nodes with keys strictly greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
package com.dsa;

import com.dsa.structures.TreeNode;

public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println("Valid BST: - " + validateBST(root));
    }

    private static boolean validateBST(TreeNode root) {
        return validateBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBSTUtil(TreeNode root, int min, int max) {
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return validateBSTUtil(root.left, min, root.val) && validateBSTUtil(root.right, root.val, max);
    }
}
