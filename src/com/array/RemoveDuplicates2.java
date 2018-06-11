package com.array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates2 {

    /**
     * 双指针法
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        final int len = nums == null ? 0 : nums.length;
        int count = 0;
        for (int i = 1; i < len; i++) {
            if(i == len - 1) {
                count++;
                nums[count] = nums[i];
            } else if(nums[count] != nums[i] || nums[count] != nums[i + 1]) {
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }


    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,3,4,4,4,5};
        int count = removeDuplicates(arr);
        for (int i = 0; i < count; i++) {
            System.out.println("i = " + arr[i]);
        }
    }

}
