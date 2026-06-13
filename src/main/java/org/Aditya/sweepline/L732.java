package org.Aditya.sweepline;

import java.util.Map;
import java.util.TreeMap;

public class L732 {
    Map<Integer, Integer> mp;

    public L732() {
        mp = new TreeMap<>();
    }


    public int book(int startTime, int endTime) {

        int cntS = mp.getOrDefault(startTime, 0);
        int cntE = mp.getOrDefault(endTime, 0);

        mp.put(startTime, cntS+1);
        mp.put(endTime, cntE-1);

        int mx = 0;
        int curr = 0;
        for(Map.Entry<Integer, Integer> entry: mp.entrySet()){

            curr += entry.getValue();
            mx = Math.max(curr, mx);

        }

        return mx;
    }
}

//
//A k-booking happens when k events have some non-empty intersection (i.e., there is some time that is common to all k events.)
//
//You are given some events [startTime, endTime), after each given event, return an integer k representing the maximum k-booking between all the previous events.
//
//Implement the MyCalendarThree class:
//
//MyCalendarThree() Initializes the object.
//int book(int startTime, int endTime) Returns an integer k representing the largest integer such that there exists a k-booking in the calendar.
//
//
//Example 1:
//
//Input
//["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
//        [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
//Output
//[null, 1, 1, 2, 3, 3, 3]
//
//Explanation
//MyCalendarThree myCalendarThree = new MyCalendarThree();
//myCalendarThree.book(10, 20); // return 1
//myCalendarThree.book(50, 60); // return 1
//myCalendarThree.book(10, 40); // return 2
//myCalendarThree.book(5, 15); // return 3
//myCalendarThree.book(5, 10); // return 3
//myCalendarThree.book(25, 55); // return 3
//
//
//
//Constraints:
//
//        0 <= startTime < endTime <= 109
//At most 400 calls will be made to book.