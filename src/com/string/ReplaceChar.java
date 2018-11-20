package com.string;

import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class ReplaceChar {

    public static void main(String[] args) throws UnsupportedEncodingException {
        /*String s = "好是好";
        System.out.println(s.replaceAll("好", ""));
        String s1 = "$是$";
        System.out.println(s1.replaceAll("$", ""));
        System.out.println(s1.replace("$", ""));
        s.charAt(i);

        String s2 = "好是好";
        byte[] b = s2.getBytes("UTF-8");
        System.out.println(new String(b, "UTF-8"));

//		String[] arr = {"张一","李","郑"};
        String[] arr = {"张一","张四","张二"};
//		String[] arr = {"s","z","w"};

        Arrays.sort(arr, Collator.getInstance(Locale.CHINESE));
        for(String a : arr) {
            System.out.println(a);
        }*/

        //System.out.println("args = [" + compareStrings("ABCD", "") + "]");
//        compareStrings("ABCD", "AACD");

        System.out.println("args = [" + digitCounts(3, 33) + "]");
    }


    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public static int digitCounts(int k, int n) {
        // write your code here
//        long start = System.currentTimeMillis();
        int num = 0;
        if(k == n) {
            num++;
            return num;
        }
        while (n >= k) {
            int target = n;
            if(target == k) {
                num++;
                n--;
                continue;
            }
            while (target > 0) {
                if(target % 10 == k) {
                    num++;
                }
                target = target / 10;
            }
            n--;
        }
        for (int i = k; i <= n; i++) {
            int t = i;
            if(t == k) {
                num++;
                continue;
            }
            while (t > 0) {
                if(t % 10 == k) {
                    num++;
                }
                t = t / 10;
            }
        }
//        System.out.println("end = [" + (System.currentTimeMillis() -  start) + "]");
        return num;

    }


    public static boolean compareStrings(String A, String B) {
        // write your code here
        boolean state = false;

        final int aLen = A == null ? 0 : A.length();
        final int bLen = B == null ? 0 : B.length();
        if(bLen <= 0) {
            state = true;
            return state;
        }

        int i = 0;
        int j = 0;


        while (j < bLen) {
            char bb = B.charAt(j);
            while (i < aLen) {
                char aa = A.charAt(i);
                if (aa == bb) {
                    i++;
                    j++;
                    break;
                } else {
                    i++;
                }
            }
            if(i == aLen) {
                state = false;
                break;
            } else if (j == (bLen - 1)) {
                state = true;
                break;
            }
        }
        return state;
    }
}
