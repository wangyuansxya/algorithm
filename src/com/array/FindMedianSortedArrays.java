package com.array;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 */
public class FindMedianSortedArrays {


    private static float findMedia(int[] arr1, int[] arr2, int len1, int len2) {

        int newLen = len1 + len2;
        int first = 0;
        int second = 0;

        int[] newArr = new int[newLen];
        for (int i = 0; i < newLen; i++) {
            if(first == len1) {//第一个数组已经完成
                newArr[i] = arr2[second++];
            } else if(second == len2) {//第二个数组已经完成
                newArr[i] = arr1[first++];
            } else {
                if(arr1[first] < arr2[second]) {
                    newArr[i] = arr1[first++];
                } else {
                    newArr[i] = arr2[second++];
                }
            }
        }

        if(newLen % 2 == 1) {
            int  index = newLen / 2;
            return newArr[index];
        } else {
            int index = newArr[newLen / 2] + (newArr[(newLen / 2) - 1] );
            return index / 2.0f;
        }

    }


    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {2, 3};

        System.out.println("args = [" + findMedia(arr1, arr2, arr1.length, arr2.length) + "]");
    }

}
