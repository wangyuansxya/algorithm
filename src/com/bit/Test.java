package com.bit;

public class Test {


    public static void main(String[] args) {

        int x = 2;
        int y = 5;

//        System.out.println("与 = [" + (y & x) + "]");
//
//        System.out.println("与1 = [" + (x & y) + "]");
//
//        System.out.println("或 = [" + (x | y) + "]");

//        System.out.println("亦或 = [" + ((x ^ y) ^ y) + "]");

//        System.out.println("非 = [" + (-x) + "]");
//        System.out.println(" = [" + (x << y) + "]");

        int[] B = {1,2,3,4};
        int[] A = {6,6,7,8};
        int[] result = mergeSortedArray(A, B);

        for (int i = 0; i < result.length; i++) {
            System.out.println("args = [" + result[i] + "]");
        }
    }



    public static int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        final int lenA = A == null ? 0 : A.length;
        final int lenB = B == null ? 0 : B.length;
        int[] result = new int[lenA + lenB];

        int i = 0;
        int j = 0;
        int k = 0;
        while (k < (lenA + lenB)) {
            if(i < lenA && j < lenB) {
                int a = A[i];
                int b = B[j];
                if(a > b) {
                    result[k] = b;
                    k++;
                    j++;
                } else if(a < b){
                    result[k] = a;
                    k++;
                    i++;
                } else {
                    result[k] = a;
                    k++;
                    result[k] = b;
                    i++;
                    j++;
                    k++;
                }
            } else if(i < lenA) {
                result[k] = A[i];
                i++;
                k++;
            } else {
                result[k] = B[j];
                j++;
                k++;
            }
        }
        return result;
    }
}
