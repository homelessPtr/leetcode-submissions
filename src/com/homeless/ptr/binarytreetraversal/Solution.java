package com.homeless.ptr.binarytreetraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 */
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        if (root != null) {
            if (root.right != null) {
                nodes.push(root.right);
                root.right = null;
            }

            if (root.left != null) {
                nodes.push(root.left);
                root.left = null;
            }

        }
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.pop();
            if (curr != null) {

                if (curr.left == null && curr.right == null) {
                    ret.add(curr.val);
                }

                if (curr.right != null) {
                    if (!nodes.contains(curr)) {
                        nodes.push(curr);
                    }
                    nodes.push(curr.right);
                    curr.right = null;
                }

                if (curr.left != null) {
                    if (!nodes.contains(curr)) {
                        nodes.push(curr);
                    }
                    nodes.push(curr.left);
                    curr.left = null;
                }

            }
        }
        return ret;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}