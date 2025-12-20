package org.example.algorithm;

import org.example.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZFontTraversalOfBinaryTree {
    public List<List<Integer>> zFontTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {return result;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrder = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<TreeNode> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isOrder) {
                    temp.addLast(node);
                } else {
                    temp.addFirst(node);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                list.add(temp.get(i).val);
            }
            result.add(list);
            isOrder = !isOrder;
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

