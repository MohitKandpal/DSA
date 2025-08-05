/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 */
package com.dsa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String data = serialize(root);
        System.out.println("Serialized String: - " + data);

        root = deserialize(data);
        System.out.println(root);
    }

    public static String serialize(TreeNode root) {
        if(root == null)
            return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeUtil(queue);
    }

    public static TreeNode deserializeUtil(Queue<String> queue) {
        String str = queue.poll();
        if(null != str && str.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = deserializeUtil(queue);
        root.right = deserializeUtil(queue);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


