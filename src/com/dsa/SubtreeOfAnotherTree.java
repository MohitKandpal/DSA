/**
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 */
package com.dsa;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println("subTree: - " + isSubTree(root, subRoot));
    }

    public static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if(subRoot == null)
            return true;
        if(root == null)
            return false;

        if(isIdentical(root, subRoot))
            return true;
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    private static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;
        return root.val == subRoot.val && isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }
}
