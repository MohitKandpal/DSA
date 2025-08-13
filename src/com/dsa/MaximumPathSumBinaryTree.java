/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
package com.dsa;

import com.dsa.structures.TreeNode;

public class MaximumPathSumBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Maximum Path Sum: - " + findMaxPathSum(root));
    }

    private static int findMaxPathSum(TreeNode root) {
        Result res = new Result();
        findMaxPathSumUtil(root, res);
        return res.val;
    }

    private static int findMaxPathSumUtil(TreeNode root, Result res) {
        if(root == null)
            return 0;
        int leftSum = findMaxPathSumUtil(root.left, res);
        int rightSum = findMaxPathSumUtil(root.right, res);
        int maxSingle = Math.max(root.val, root.val + Math.max(leftSum, rightSum));
        int maxTop = Math.max(maxSingle, root.val + leftSum + rightSum);
        res.val = Math.max(res.val, maxTop);
        return maxSingle;
    }

}

class Result {
    int val;
    public Result() {
        this.val = Integer.MIN_VALUE;
    }
}
