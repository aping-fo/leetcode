package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class GetPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);

        TreeNode node3 = new TreeNode(11);

        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        System.out.println(pathSum(root, 22));
    }


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> all = new ArrayList<>();
        hasPathSum(root, sum, all, new ArrayList<>());
        return all;
    }


    public static void hasPathSum(TreeNode root, int sum, List<List<Integer>> all, List<Integer> curList) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                ArrayList<Integer> arrayList = new ArrayList<>(curList);
                arrayList.add(root.val);
                all.add(new ArrayList<>(arrayList));
            }
            return;
        }
        curList.add(root.val);
        hasPathSum(root.left, sum - root.val, all, curList);
        hasPathSum(root.right, sum - root.val, all, curList);
        if (curList.size() > 0) curList.remove(curList.size() - 1);
    }
}
