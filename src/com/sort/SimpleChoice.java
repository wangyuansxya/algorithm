package com.sort;

/**
 * 简单选择排序
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，
 * 如此循环到倒数第二个数和最后一个数比较为止。
 */
public class SimpleChoice {

    private static void simple(int[] arr) {
        final int len = arr == null ? 0 : arr.length;
        int position;
        for (int i = 0; i < len; i++) {
            position = i;
            int temp = arr[i];
            for (int j = i + 1; j < len; j++) {
                if(arr[j] < temp) {
                    temp = arr[j];
                    position = j;
                }
            }
            arr[position] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 10, 7, 8, 11, 6, 15, 4, 19, 2};
        simple(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i = " + arr[i]);
        }
    }

}
