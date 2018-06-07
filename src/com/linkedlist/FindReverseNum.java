package com.linkedlist;

/**
 * 找出单链表中倒数第k个位置上的元素
 * @author wangyuan
 *
 */
public class FindReverseNum {

	public static final String[] ARR = 
		{"a", "b","c", "d","e", "f","g", "h","i", "j","k", "l"};
	

	public static void main(String[] args) {
		int a = 'a';
		int b = 'b';
		
		System.out.println("before a = " + a);
		System.out.println("before b = " + b);
		
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		
		System.out.println("after a = " + a);
		System.out.println("after b = " + b);
		/*System.out.println(a ^ b);
		System.out.println(a ^ b);*/
	}
}
