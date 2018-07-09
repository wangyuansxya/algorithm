package com.num;

public class Reverse {

    private static int reverse(int x) {
        boolean isLow = false;
        if(x < 0) {
            isLow = true;
            x = -x;
        }

        /**
         * 注意：这个变量一定要是long
         */
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

    /**
     * 回文数 正序和倒序读都是一样的
     * @param x
     * @return
     * 转为String ，双向指针解决
     */
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        boolean isPalindrome = true;
        String s = String.valueOf(x);
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
                continue;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }


    public static void main(String[] args) {
        //int i = reverse(1534236469);
        //System.out.println("args = [" + i + "]");

        System.out.println("args = [" + isPalindrome(0) + "]");
    }

}
