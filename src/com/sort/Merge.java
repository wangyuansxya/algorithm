package com.sort;

import java.util.*;

public class Merge {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    /**
     * [[1,3],[2,6],[5,7],[8,10],[15,18]]
     * @param intervals
     * @return
     */
    public static List<Interval> merge(List<Interval> intervals) {

        final int len = intervals.size();
        int[] start = new int[len];
        int[] end = new int[len];

        for (int i = 0; i < len; i++) {
            Interval item = intervals.get(i);
            start[i] = item.start;
            end[i] = item.end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        List<Interval> list = new ArrayList<>();

        int left = start[0];
        int right = end[0];

        for (int i = 0; i < len - 1; i++) {

            if(start[i + 1] > end[i]) {//区间断开
                list.add(new Interval(left, right));
                left = start[i + 1];
            } else {
                right = end[i];
            }
        }


        /*int i = 1;
        while (i < intervals.size()) {
            Interval s = intervals.get(i);
            Interval f = intervals.get(i - 1);
            if(s.start <= f.end) {
                f.end = Math.max(f.end, s.end);
                f.start = Math.min(f.start, s.start);
                intervals.remove(i);
            } else {
                i++;
            }

        }*/
        return list;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        Interval i = new Interval(1,4);
        list.add(i);

        i = new Interval(0,4);
        list.add(i);

        /*i = my Interval(5,7);
        list.add(i);

        i = my Interval(8,10);
        list.add(i);

        i = my Interval(15,18);
        list.add(i);*/


        List<Interval> arr = merge(list);
        for (Interval item : arr) {
            System.out.println("start = [" + item.start + "]");
            System.out.println("end = [" + item.end + "]");
        }



    }

}
