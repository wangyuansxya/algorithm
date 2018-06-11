package com.sort;

public class MaoPaoSort {

    private static void maopao(int[] arr) {
        final int len = arr == null ? 0 : arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if(arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 10, 7, 8, 11, 6, 15, 4, 19, 2};
        maopao(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i = " + arr[i]);
        }
    }
}
