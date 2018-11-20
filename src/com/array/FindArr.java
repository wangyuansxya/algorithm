package com.array;

import java.util.*;

public class FindArr {

    public static void main(String[] args) {

        String[] arr = {};


        /*String[] s = topKFrequentWords(arr, 4);
        for (int i = 0; i < s.length; i++) {
            System.out.println("s = [" + s[i] + "]");
        }*/
//        trailingZeros(12);

       /* char[] str = {'a', 'b', 'c', 'c', 'b', 'a', 'g'};
        char[] a = {};
        rotateString(a, 25);*/

       int[] nums = {1, 3, 4, 2};
       int k = kthLargestElement(3, nums);
        System.out.println("k = [" + k + "]");
    }

    public static int kthLargestElement(int n, int[] nums) {
        // write your code here
        final int len = nums == null ? 0 : nums.length;
        if(n < 0 || n > len) return 0;
        int start = 0;
        int end = len;
        return nums[n - 1];
    }



    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public static void rotateString(char[] str, int offset) {
        // write your code here
        if(offset <= 0) {
            offset = -offset;
        }
        final int len = str == null ? 0 : str.length;
        if(len <= 0) return;
        offset = offset % len;
        char[] result = new char[len];
        for (int i = 0; i < len ; i++) {
            int index = i + offset;
            if(index < len) {
                result[index] = str[i];
            } else {
                int x = index - len;
                result[x] = str[i];
            }
        }
        for (int i = 0; i < len; i++) {
            str[i] = result[i];
        }
    }


    public static long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long sum = 1;
        if(n >= 0) {
            for(long i = n; i > 0; i--) {
                sum = sum * i;
            }
        } else {
            for(long i = n; i < 0; i++) {
                sum = sum * i;
            }
        }

        System.out.println("sum = [" + sum + "]");

        int count = 0;
        while ((sum % 10) == 0) {
            count++;
            sum = sum / 10;
        }
        System.out.println("count = [" + count + "]");
        return count;
    }

    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public static String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        if(k <= 0 || words == null || words.length <= 0) return new String[0];
        HashMap<String, Integer> map = new HashMap<>();
        final int len = words == null ? 0 : words.length;
        for (int i = 0; i < len; i++) {
            if(map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> f, Map.Entry<String, Integer> s) {
                if(f.getValue() > s.getValue()) {
                    return -1;
                } else if(f.getValue() < s.getValue()) {
                    return 1;
                }
                return f.getKey().compareTo(s.getKey());
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println("words = [" + list.get(i).getKey() + "], k = [" + list.get(i).getValue() + "]");
        }

        String[] result = null;
        for (int i = 0; i < k; i++) {
            if(result == null)result = new String[k];
            result[i] = list.get(i).getKey();
        }
        return result;
    }

}
