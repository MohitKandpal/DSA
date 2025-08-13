/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
package com.dsa;

import com.dsa.structures.TreeNode;

import java.util.ArrayList;

public class KthSmalllestBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println("Kth smallest element is: - " + findKthSmallest(root, 2));
    }

    private static int findKthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        kthSmallestUtil(root, list);
        return list.get(k - 1);
    }

    private static void kthSmallestUtil(TreeNode root, ArrayList<Integer> list) {
        if(root != null) {
            kthSmallestUtil(root.left, list);
            list.add(root.val);
            kthSmallestUtil(root.right, list);
        }
    }
}
