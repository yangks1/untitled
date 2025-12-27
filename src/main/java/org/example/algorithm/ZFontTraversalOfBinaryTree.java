package org.example.algorithm;

import org.example.model.TreeNode;

import java.util.*;

public class ZFontTraversalOfBinaryTree {
    public List<List<Integer>> zFontTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean flag = false;
        while (!deque.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int levelSize = deque.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.poll();
                if(flag) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        List<List<Integer>> result = new ZFontTraversalOfBinaryTree().zFontTraversal(root);
        System.out.println(result);
    }



}

