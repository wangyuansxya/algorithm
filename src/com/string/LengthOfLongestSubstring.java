package com.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出字符串中，俩个相同字符出现的最远距离
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        // write your code here
        System.out.print(lengthOfLongestSubstring("abcdccadeb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        final int len = s == null ? 0 : s.length();
        int start = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            result = Math.max(result, i - start + 1);
            map.put(c, i + 1);
        }
        if(result == 0) {
            result = len;
        }
        return result;
    }

}
