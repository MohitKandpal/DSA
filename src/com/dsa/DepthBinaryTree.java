/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
package com.dsa;

import com.dsa.structures.TreeNode;

public class DepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        System.out.println("Maximum Depth: - " + findDepth(root));
    }

    private static int findDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int ldepth = findDepth(root.left);
        int rdepth = findDepth(root.right);
        return Math.max(ldepth, rdepth) + 1;
    }
}
