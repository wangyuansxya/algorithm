package com.find;

public class TwoFindTest {

    private static int find(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int middle = (high + low) / 2;
            if(arr[middle] < target) {
                low = middle;
            } else if(arr[middle] > target) {
                high = middle;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        System.out.println(find(arr, 15));



    }

}
