/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
package com.dsa;

import com.dsa.structures.TreeNode;

public class LCABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        System.out.println("LCS of " + node1.val + " and " + node2.val + " is: - " + findLCA(root, node1, node2).val);
    }

    private static TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
        if(root == null)
            return null;
        if(root.val > n1.val && root.val > n2.val)
            return findLCA(root.left, n1, n2);
        if(root.val < n1.val && root.val < n2.val)
            return findLCA(root.right, n1, n2);
        return root;
    }
}
