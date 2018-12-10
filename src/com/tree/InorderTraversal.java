package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    private static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return null;
        }
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        /*while (root != null || stack.size() > 0) {
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
        }*/
        st.push(root);
        while(!st.isEmpty()) {
            root = st.pop();
            list.add(root.val);
            if(root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
        }

        return list;
    }

    public static void main(String[] args) {

            TreeNode root = new TreeNode(1);
            root.right = new TreeNode(2);
            root.right.left = new TreeNode(3);
            root.left = new TreeNode(4);
            List<Integer> res = inorderTraversal(root);
            for (Integer i : res) {
                System.out.println("args = [" + i + "]");
            }

    }
}
