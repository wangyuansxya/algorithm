package com.BackPack;

public class BackPack {

    public static int backPack(int m, int[] A) {
        // write your code here
        if(m <= 0) return 0;
        int q = Integer.MIN_VALUE;
        int i = 0;
        int index = 0;
        /*while (i < m) {
            q =
        }*/




//        int q = Integer.MAX_VALUE;
//        final int len = A == null ? 0 :  A.length;
//        for (int i = 0; i < len; i++) {
//            q = Math.min(m - A[i], q);
////            q = Math.max(q, A[i] + backPack(m - A[i], A));
//        }
//        return m - q;



//        int MaxSum = A[0];
//        int sum = 0;
//        for (int i = 0;i < len;i++)
//        {
//            sum = 0;
//            for (int j = i;j < len;j++) {
//                sum += A[j];
//                MaxSum = Math.max(MaxSum,sum);
//            }
//        }
//        return MaxSum;
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 13, 5, 7, 11, 5};
//        int[] arr = {2};
        System.out.println("args = [" + backPack(22, arr) + "]");

    }

}
