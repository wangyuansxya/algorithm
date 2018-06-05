package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        // write your code here
        System.out.print(lengthOfLongestSubstring("abcdccadeb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        if(s == null) {
            return 0;
        }
        int start = 0;
        int result = 0;

        final int len = s.length();
        Map<Character, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            //如果字符已经出现过(在标记开位置算起)，就重新标记start
            if(map.containsKey(c)) {
                start = map.get(c) + 1;
            } else {
                result = Math.max(result, i - start + 1);
            }
            map.put(c, i);
        }
        return result;
    }

}
