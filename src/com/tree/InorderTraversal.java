package com.tree;

import java.util.*;

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
        /*List<Integer> res = inorderTraversal(root);
        for (Integer i : res) {
            System.out.println("args = [" + i + "]");
        }*/
        /*List<List<Integer>> result = new ArrayList<>();
        int index = 0;

        while (!queue.isEmpty()) {



        }
        for (TreeNode i : queue) {
            System.out.println("args = [" + i.val + "]");
        }*/
        List<List<Integer>> res = levelOrder(root);

        for (List<Integer> item: res) {
            if(item == null) continue;
            System.out.println("item = [" + item + "]");
            /*for (int i : item) {
                System.out.println("i = [" + i + "]");
            }*/
        }
    }


    /**
     * 层序遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        if(root == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue =  new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList<>(size);
            for (int i = 0 ; i < size; i++) {
                root = queue.poll();
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
                l.add(root.val);
            }
            result.add(l);
        }
        return result;
    }
}
