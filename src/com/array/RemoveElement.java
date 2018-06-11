package com.array;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {

    private static int removeElement(int[] nums, int val) {
        int count = 0;
        int len = nums == null ? 0 : nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int c = removeElement(nums, 2);
        System.out.println("count = [" + c + "]");
        for (int i = 0; i < c; i++) {
            System.out.println("args " + i + "= [" + nums[i] + "]");
        }
    }

}
