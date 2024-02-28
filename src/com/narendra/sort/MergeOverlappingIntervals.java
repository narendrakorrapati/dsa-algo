package com.narendra.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        //Interval[] arr = new Interval[] {new Interval(3, 6), new Interval(1, 4), new Interval(9, 12), new Interval(8, 10)};
        //Interval[] arr = new Interval[] {new Interval(1, 5), new Interval(2, 4)};
        Interval[] arr = new Interval[] {new Interval(4, 6), new Interval(6, 8), new Interval(1, 3)};
        ArrayList<Interval> merge = mergeIntervals(arr);
        System.out.println(merge);

    }

    private static ArrayList<Interval> mergeIntervals(Interval[] arr) {

        Arrays.sort(arr);
        ArrayList<Interval> result = new ArrayList<>();
        result.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            Interval current = arr[i];
            Interval lastMerged = result.get(result.size()-1);

            if(current.start <=lastMerged.end) {
                lastMerged.start = Math.min(current.start, lastMerged.start);
                lastMerged.end = Math.max(current.end, lastMerged.end);
            } else {
                result.add(current);
            }
        }
        return result;
    }


}

class Interval implements Comparable<Interval>{
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "["+start+","+end+"]";
    }

    @Override
    public int compareTo(Interval o) {

        if(this.start == o.start) {
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}


