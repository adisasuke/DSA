package org.Aditya.sweepline;

import java.util.Arrays;

public class L1589 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {

        int n = nums.length;

        int intersection[] = new int[n+1];


        for(int i=0;i<requests.length;i++){

            int start = requests[i][0];
            int end = requests[i][1];

            intersection[start] += 1;
            intersection[end+1] -= 1;
        }

        for(int i=1;i<=n;i++){
            intersection[i] += intersection[i-1];
        }

        Arrays.sort(nums);
        Arrays.sort(intersection);

        // reverse nums
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // reverse intersection
        for (int i = 0, j = intersection.length - 1; i < j; i++, j--) {
            int temp = intersection[i];
            intersection[i] = intersection[j];
            intersection[j] = temp;
        }

        long mod = (long)(1e9+7);
        long ans = 0;


        for(int i=0, ind=0;i<n;i++, ind++){

            if(intersection[ind]==0){
                break;
            }


            long temp = (intersection[ind] *1l* nums[i])%mod;
            ans = (ans + temp)%mod;

        }



        return (int)ans;
    }
}


//
//We have an array of integers, nums, and an array of requests where requests[i] = [starti, endi]. The ith request asks for the sum of nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi]. Both starti and endi are 0-indexed.
//
//Return the maximum total sum of all requests among all permutations of nums.
//
//Since the answer may be too large, return it modulo 109 + 7.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
//Output: 19
//Explanation: One permutation of nums is [2,1,3,4,5] with the following result:
//requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
//requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
//Total sum: 8 + 3 = 11.
//A permutation with a higher total sum is [3,5,4,2,1] with the following result:
//requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
//requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
//Total sum: 11 + 8 = 19, which is the best that you can do.
//Example 2:
//
//Input: nums = [1,2,3,4,5,6], requests = [[0,1]]
//Output: 11
//Explanation: A permutation with the max total sum is [6,5,4,3,2,1] with request sums [11].
//Example 3:
//
//Input: nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
//Output: 47
//Explanation: A permutation with the max total sum is [4,10,5,3,2,1] with request sums [19,18,10].
//
//
//Constraints:
//
//n == nums.length
//1 <= n <= 105
//        0 <= nums[i] <= 105
//        1 <= requests.length <= 105
//requests[i].length == 2
//        0 <= starti <= endi < n