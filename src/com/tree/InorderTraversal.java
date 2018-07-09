package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    private static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || stack.size() > 0) {
            //左子树入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.size() > 0) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {



    }
}
