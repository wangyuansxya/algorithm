package com.algorithm;

public class AddTwoNumbers {

    public static void main(String[] args) {
        // write your code here

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

    public ListNode addTwoNumbers(ListNode p1, ListNode p2) {
        if(p1 == null) {
            return p2;
        }
        if(p2 == null) {
            return p1;
        }

        //返回的结果node
        ListNode result = p1;
        //进位
        int carry = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            result.val = sum % 10;// 本位的结果
            carry = sum / 10;// 本次进位

            p1 = p1.next;
            p2 = p2.next;
            result.next = p1;
        }

        if(carry > 0) {
            result.next = new ListNode(carry);
        }
        return result;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
