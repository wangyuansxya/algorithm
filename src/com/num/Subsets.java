package com.num;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        // 子集个数是2n次幂
        final int len = nums == null ? 0 : nums.length;
        int len1 = (int)Math.pow(2, len);
        List<List<Integer>> lists = new ArrayList<List<Integer>>(len1);

        return null;

    }

    public static void main(String[] args) {

    }
}
