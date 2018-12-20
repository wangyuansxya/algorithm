package com.linkedlist;

public class NodeSolution {

    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public static ListNode reverse(ListNode head) {
        // write your code here
        /*ListNode preNode = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;*/
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy.next;
        ListNode current = prev == null ? null : prev.next;
        while (current != null) {
            prev.next = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = prev.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(5);
        first.next.next.next.next.next = new ListNode(6);


//        ListNode result = reverse(null);
        ListNode result = reverseBetween(first, 0, 0);
        print("result", result);
    }

    private static void print(String flag, ListNode result) {
        while (result != null) {
            System.out.println(flag + " = [" + result.val + "]");
            result = result.next;
        }
    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if(head == null || m == n) return head;
        ListNode preNode = null;//前一个节点
        ListNode p = head;//当前节点

        /**
         * 获取需要开始反转的第一个节点
         */
        int start = 1;
        while (start < m) {
            ListNode next = p.next;
            preNode = p;
            p = next;
            start++;
        }

        /**
         * 反转操作
         */
        //反转的节点头
        ListNode startNode = null;
        //当前的节点位置
        ListNode currentNode = p;//当前节点
        /**
         * 第一个反转的节点
         */
        ListNode endNode = null;
        while (start <= n && currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = startNode;
            startNode = currentNode;
            if(endNode == null) {
                endNode = startNode;
            }
            currentNode = next;
            start++;
        }

        /**
         * 反转之后，将节点拼接起来
         */
        endNode.next = currentNode;
        //preNode == null，说明是从第一个节点开始反转的
        if(preNode != null) {
            preNode.next = startNode;
        } else {
            head = startNode;
        }
        return head;
    }



}
