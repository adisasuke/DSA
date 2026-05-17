package org.Aditya.bitMask;

import java.util.Arrays;

public class L1879 {

    int[] dp;

    private int solve(int mask, int nums1[], int nums2[]){


        int n = nums1.length;

        int cnt = Integer.bitCount(mask);

        if(cnt==n){
            return 0;
        }

        if(dp[mask]!=-1){
            return dp[mask];
        }

        int ans = Integer.MAX_VALUE;

        for(int j=0;j<n;j++){

            if( (mask & (1<<j)) == 0){
                int newMask = mask | (1<<j);
                int val = nums1[cnt]^nums2[j];
                ans = Math.min(ans, val + solve(newMask, nums1, nums2));
            }


        }



        return dp[mask] = ans;
    }





    public int minimumXORSum(int[] nums1, int[] nums2) {

        int n = nums1.length;
        dp = new int[(1<<n) + 1];
        Arrays.fill(dp, -1);

        return solve(0, nums1, nums2);
    }

    public static void main(String[] args) {
        L1879 l1879 = new L1879();
        int nums1[] = {1,2};
        int nums2[] = {2,3};
        int ans = l1879.minimumXORSum(nums1, nums2);
        System.out.println("Maximum xor sum is: " + ans);

    }
}
