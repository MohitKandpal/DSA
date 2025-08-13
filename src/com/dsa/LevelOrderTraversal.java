/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
package com.dsa;

import com.dsa.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        System.out.println(findLevelOrderTraversal(root));
    }

    private static List<List<Integer>> findLevelOrderTraversal(TreeNode root) {
        if(root == null)
            return null;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> interimList = new ArrayList<Integer>();
            for(int i = 0; i < count; i++) {
                TreeNode poppedNode = queue.remove();
                interimList.add(poppedNode.val);
                if(poppedNode.left != null) {
                    queue.add(poppedNode.left);
                }
                if(poppedNode.right != null) {
                    queue.add(poppedNode.right);
                }
            }
            ans.add(interimList);
        }
        return ans;
    }
}
