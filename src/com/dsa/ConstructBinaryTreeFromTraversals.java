/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
package com.dsa;

import com.dsa.structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromTraversals {
    public static void main(String[] args) {
        int[] in = {3,9,20,15,7}, pre = {9,3,15,20,7};
        TreeNode root = createFromInorderPreorder(in, pre);
        System.out.println("Preorder from created tree: - ");
        preorder(root);
    }

    private static TreeNode createFromInorderPreorder(int[] in, int[] pre) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return createUtil(pre, map, 0, in.length -1, 0, pre.length - 1);
    }

    private static TreeNode createUtil(int[] pre, Map<Integer, Integer> map,
                   int inOrdStart, int inOrdEnd, int preOrdStart, int preOrdEnd) {
        if(preOrdStart > preOrdEnd || inOrdStart > inOrdEnd)
            return null;
        int ind = map.get(pre[preOrdStart]);
        int numsLeft = ind - inOrdStart;
        TreeNode root = new TreeNode(pre[preOrdStart]);
        root.left = createUtil(pre, map, inOrdStart, ind - 1, preOrdStart + 1, preOrdStart + numsLeft);
        root.right = createUtil(pre, map, ind + 1, inOrdEnd, preOrdStart + numsLeft + 1, preOrdEnd + numsLeft);
        return root;
    }

    private static void preorder(TreeNode root) {
        if(root != null) {
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

}
