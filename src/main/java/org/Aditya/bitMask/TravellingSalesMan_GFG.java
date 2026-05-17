package org.Aditya.bitMask;

import java.util.Arrays;

public class TravellingSalesMan_GFG {

    int dp[][];

    private int solve(int node, int mask, int cost[][]){

        int n = cost.length;

        int cnt = Integer.bitCount(mask);

        if(cnt==n){
            return cost[node][0];
        }


        if(dp[node][mask]!=-1){
            return dp[node][mask];
        }

        int ans = Integer.MAX_VALUE;


        for(int j=n-1;j>=0;j--){

            if((mask&(1<<j))==0){


                ans = Math.min(ans, cost[node][j] + solve(j, mask | (1<<j), cost) );

            }

        }


        return dp[node][mask] = ans;

    }






    public int tsp(int[][] cost) {
        // code here

        int n = cost.length;


        dp = new int[n][(1<<n)-1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 1, cost);

    }

    public static void main(String[] args) {

        TravellingSalesMan_GFG  travellingSalesManGfg = new TravellingSalesMan_GFG();
        int [][] cost = {
                {0, 1000, 5000},
                {5000, 0, 1000},
                {1000, 5000, 0}
        };

        int ans = travellingSalesManGfg.tsp(cost);

        System.out.println("cost to travel is : " + ans);
    }


}
