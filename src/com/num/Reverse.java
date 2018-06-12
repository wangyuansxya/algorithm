package com.num;

public class Reverse {

    private static int reverse(int x) {
        boolean isLow = false;
        if(x < 0) {
            isLow = true;
            x = -x;
        }

        long result = 0;
        while (x > 0) {
            result *= 10;
            long temp = x % 10;
            x /=10;
            result += temp;

        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int)(isLow ? -result : result);
    }

    public static void main(String[] args) {
        int i = reverse(1534236469);
        System.out.println("args = [" + i + "]");
    }

}
