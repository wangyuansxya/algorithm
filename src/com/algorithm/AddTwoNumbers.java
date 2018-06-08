package com.algorithm;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        // write your code here
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = addTwoNumbers(l1, l2);
        System.out.println("args = [" + res.val + "]");
        System.out.println("args = [" + res.next.val + "]");
        System.out.println("args = [" + res.next.next.val + "]");
        System.out.println("args = [" + res.next.next.next.val + "]");
//        System.out.println("args = [" + res.next.next.next.val + "]");
    }

    /**
     * 思路讲解
     * 俩个列表保存的数据都是反向的，即开始保存的低位，最后保存的是高位
     * 相同位的俩个数字相加可以的到改位的总和，对10求余即是该位最后的和
     * 对10求上即是需要进位的值
     * @param p1
     * @param p2
     * @return
     */

    public static ListNode addTwoNumbers(ListNode p1, ListNode p2) {
        if(p1 == null) {
            return p2;
        }
        if(p2 == null) {
            return p1;
        }

        //返回的结果node
        ListNode result = new ListNode(0);
        ListNode current = result;

        //进位
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p1 == null ? 0 : p2.val;
            int sum = x + y + carry;
            //current.val = sum % 10;// 本位的结果
            carry = sum / 10;// 本次进位
            current.next = new ListNode(sum % 10);
            current = current.next;

            if(p1 != null)p1 = p1.next;
            if(p2 != null)p2 = p2.next;

        }
        if(carry > 0) {
            current.next = new ListNode(carry);
        }
        return result.next;

    }

    public static class ListNode {
        public int val;//进位
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
