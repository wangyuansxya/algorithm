package com.two;

public class TwoTest {

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

    private static void quickSort(int[] arr, int low, int high) {
        //1,找到递归算法的出口
        if(low > high)return;

        //2, 存
        int start = low;
        int end = high;

        //3,key
        int target = arr[start];
        //4，完成一趟排序
        while (start < end) {
            //4.1 ，从右往左找到第一个小于key的数
            while (start < end && arr[end] > target) {
                end--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while (start < end && arr[start] <= target) {
                start++;
            }
            //4.3 交换
            if(start < end) {
                swap(arr, start, end);
            }
        }
        // 4.4，调整key的位置
        swap(arr, start, low);

        //5, 对key左边的数快排
        quickSort(arr, low, start - 1);
        //6, 对key右边的数快排
        quickSort(arr, start + 1, high);

    }

    private static void swap(int[] arr, int start, int end) {
        int t = arr[start];
        arr[start] = arr[end];
        arr[end] = t;
    }

    public static void main(String[] args) {
        /*int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        System.out.println(find(arr, 15));*/

        int[] arr = {12, 3, 10, 7, 8, 11, 6, 15, 4, 19, 2};

        /*int[] target = */quickSort(arr, 0, arr.length -  1);
        System.out.println("args = [" + arr.toString() + "]");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i = " + arr[i]);
        }
        //System.out.println(find(arr, 15));

    }

}
