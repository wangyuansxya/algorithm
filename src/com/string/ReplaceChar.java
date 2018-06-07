package com.string;

import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class ReplaceChar {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "好是好";
        System.out.println(s.replaceAll("好", ""));
        String s1 = "$是$";
        System.out.println(s1.replaceAll("$", ""));
        System.out.println(s1.replace("$", ""));

        String s2 = "好是好";
        byte[] b = s2.getBytes("UTF-8");
        System.out.println(new String(b, "UTF-8"));

//		String[] arr = {"张一","李","郑"};
        String[] arr = {"张一","张四","张二"};
//		String[] arr = {"s","z","w"};

        Arrays.sort(arr, Collator.getInstance(Locale.CHINESE));
        for(String a : arr) {
            System.out.println(a);
        }
    }
}
