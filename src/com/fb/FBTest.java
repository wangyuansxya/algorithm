package com.fb;

public class FBTest {

    private static int countFb(int start, int end) {

        int[] arr = new int[end];
        for (int i = 0; i < end; i++) {
            arr[i] = buildFb(i + 1);
            System.out.println(i + "=" + buildFb(i + 1));
        }

        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static int buildFb(int sum) {
        if(sum <= 0) {
            return 0;
        }
        if(sum == 1) {
            return 1;
        }
        if(sum == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int cont;
        for (int i = 2; i < sum; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
//        return buildFb(sum - 2) + buildFb(sum -1);
    }

    public static void main(String[] args) {
        System.out.println("args = " + countFb(5, 10));
    }

}
