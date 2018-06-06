package com.bit;

import java.util.Stack;

public class BitTest {

    /**
     * 不使用临时变量，交换俩个数据的值
     * 1，位运算，异或
     * 2，加减法
     */
    private static void exchange(int i, int j) {
        //异或
        i = i ^ j;
        j = j ^ i;
        i = i ^ j;

        System.out.println("使用异或i = " + i);
        System.out.println("使用异或j = " + j);

        //加减法
        j = i + j;
        i = j - i;
        j = j - i;

        System.out.println("使用加减法i = " + i);
        System.out.println("使用加减法j = " + j);


    }

    private static void exchange(String a, String b) {
        //思考。字符串交换
        /*String a = "ABC";
        String b = "DEF";*/
        //使用临时变量
        String t = a;
        a = b;
        b = t;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        //不使用临时变量
        Stack<String> stack = new Stack<>();
        stack.push(a);
        stack.push(b);
        a = stack.pop();
        b = stack.pop();

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        //交换String的值
        a = a.concat(b);
        b = a.substring(0, a.length() - b.length());
        a = a.substring(a.length() - b.length(), a.length());

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void main(String[] args) {

        //int ol = 4;
        //System.out.println("args = [" + ~ol + "]");
        //System.out.println("args = [" + (6^ol) + "]");
        exchange(2, 3);
        exchange("ABC","DEF");

    }

}
