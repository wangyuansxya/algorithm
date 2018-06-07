package com.tree;

/**
 * 输出数组中，每位数组的值，对应数组位置的数值，并输出，小于或者大于则不输出
 */
public class ArrTest {
    private static int[] format(int[] arr) {
        final int len = arr == null ? 0 : arr.length;
        int index = 0;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            if(index >= len || index < 0)continue;
            temp[i] = arr[index];
            System.out.println("arr = [" + index + "]" + "-value=" + temp[i]);
            index = temp[i];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 0, 1, 6, 8};
        format(arr);
    }
}
