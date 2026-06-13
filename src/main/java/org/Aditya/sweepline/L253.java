package org.Aditya.sweepline;
import java.util.*;

public class L253 {

    class Pair{

        int time;
        boolean isStart;

        public Pair(int time, boolean isStart){
            this.time = time;
            this.isStart = isStart;
        }


    }



    public int minMeetingRooms(int[][] intervals) {

        List<Pair> arr = new ArrayList<>();

        for(int[] interval: intervals){

            arr.add(new Pair(interval[0], true));
            arr.add(new Pair(interval[1], false));

        }


        Collections.sort(arr, (a, b)-> {

            if(a.time == b.time){

                if(a.isStart == true){
                    return 1;
                }

                return -1;

            }

            return Integer.compare(a.time, b.time);


        });

        int ans = 0;

        int curr = 0;

        for(int i=0;i<arr.size();i++){

            Pair p = arr.get(i);

            if(p.isStart == true){
                curr++;
                ans = Math.max(ans, curr);
            }else{
                curr--;
            }



        }


        return ans;

    }

    public static void main(String[] args) {

        L253 l253 = new L253();

        int intervals[][] = {
                {0, 30},
                {5, 10},
                {15, 20}
        };


        int conferenceRoom = l253.minMeetingRooms(intervals);
        System.out.println("Minimum conference rooms required " + conferenceRoom);
    }
}
//
//253. Meeting Rooms II
//        Solved
//Medium
//        Topics
//conpanies icon
//Companies
//        Hint
//Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
//
//
//
//        Example 1:
//
//Input: intervals = [[0,30],[5,10],[15,20]]
//Output: 2
//Example 2:
//
//Input: intervals = [[7,10],[2,4]]
//Output: 1
//
//
//Constraints:
//
//        1 <= intervals.length <= 104
//        0 <= starti < endi <= 106