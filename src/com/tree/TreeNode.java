package com.tree;

public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
	@Override
	public String toString() {
		return "Node [left=" + left + ", value=" + val + ", right=" + right + "]";
	}
	
}
