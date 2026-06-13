package org.Aditya.sweepline;

public class L1854 {

    private int startYear = 1950;
    private int endYear = 2050;


    public int maximumPopulation(int[][] logs) {




        int population[] = new int[endYear - startYear + 1];


        for(int i=0;i<logs.length;i++){

            int birth = logs[i][0];
            int death = logs[i][1];


            population[birth-startYear] += 1;
            population[death-startYear] -= 1;

        }

        int mx_pop=0;
        int mx_year = -1;

        int curr_pop=0;


        for(int i=0;i<population.length;i++){

            curr_pop += population[i];

            if(curr_pop>mx_pop){

                mx_pop = curr_pop;
                mx_year = i+startYear;
            }

        }

        return mx_year;
    }

    public static void main(String[] args) {
        L1854 l1854 = new L1854();
        int logs[][] = {
                {1993, 1999},
                {2000, 2010}
        };
        int earliestYear = l1854.maximumPopulation(logs);
        System.out.println("Earliest year is : " + earliestYear);
    }
}
//
//1854. Maximum Population Year
//        Solved
//Easy
//        Topics
//conpanies icon
//Companies
//        Hint
//You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
//
//The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
//
//Return the earliest year with the maximum population.
//
//
//
//Example 1:
//
//Input: logs = [[1993,1999],[2000,2010]]
//Output: 1993
//Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
//        Example 2:
//
//Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
//Output: 1960
//Explanation:
//The maximum population is 2, and it had happened in years 1960 and 1970.
//The earlier year between them is 1960.
//
//
//Constraints:
//
//        1 <= logs.length <= 100
//        1950 <= birthi < deathi <= 2050