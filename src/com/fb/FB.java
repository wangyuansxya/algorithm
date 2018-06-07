package com.fb;

/**
 * 青蛙跳台阶，共10个台阶，每次可以跳一个或者俩个，共有多少中跳法
 * 其实就是一个斐波那契数列，
 */
public class FB {

    /**
     * 递归的解决方案，如果层级过深，可能存在栈溢出的问题
     * @param num
     * @return
     */
    public static int jump(int num) {
        if(num == 1) return 1;
        else if(num == 2) return 2;
        else {
            return jump(num - 1) + jump(num - 2);
        }
    }

    /**
     * 非递归的实现方案
     * @param num
     * @return
     */
    public static int jump1(int num) {
        if(num == 1) return 1;
        else if(num == 2) return 2;
        int a = 1;
        int b = 2;
        int sum = 0;
        for(int i = 2; i < num; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(jump1(10));
    }

}
