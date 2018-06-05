package com.algorithm;

import java.util.Arrays;


public class Solution {

    public static void main(String[] args) {
        // write your code here
        int[] arr = {3, 2, 3};

        int[] result = twoSum(arr, 6);
        System.out.print(result[0] + "--" + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        final int len = nums == null ? 0 : nums.length;
        Node[] temp = new Node[len];
        for (int i = 0; i < len; i++) {
            temp[i] = new Node(nums[i], i);
        }

        Arrays.sort(temp);
        int[] result = {0, 0};

        int start = 0;
        int end = len - 1;
        while (start < end) {
            if(temp[start].val + temp[end].val == target) {
                int first = temp[start].idx + 1;
                int last = temp[end].idx + 1;
                if(first > last) {
                    result[0] = last;
                    result[1] = first;
                } else {
                    result[0] = first;
                    result[1] = last;
                }
                return result;
            } else if(temp[start].val + temp[end].val > target) {
                end--;
            } else {
                start++;
            }
        }
        return result;

    }


    private static class Node implements Comparable<Node> {
        int val;//数据
        int idx;//编号

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            if(o != null) {
                return val - o.val;
            }
            return 0;
        }
    }
}
