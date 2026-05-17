package org.Aditya.array.rotation;

public class L3942 {
    private boolean checkIfIncreasing(int[] nums, int min_idx, int n) {
        int i;
        for (i = min_idx; i < min_idx + n; ++i) {
            if (nums[(i + 1) % n] - 1 != nums[i % n]) {
                break;
            }
        }
        if ((i + 1) % n == min_idx) {
            return true;
        }
        return false;
    }

    public int minOperations(int[] nums) {
        int n = nums.length;

        // Step-1: Find min_idx
        int min_idx = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                min_idx = i;
                break;
            }
        }

        // Step-2: Find if increasing or decreasing?
        boolean is_increasing = checkIfIncreasing(nums, min_idx, n);
        boolean is_decreasing = false;

        if (!is_increasing) {
            // Reverse the array
            for (int i = 0; i < n / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[n - 1 - i];
                nums[n - 1 - i] = temp;
            }

            int temp1 = min_idx;
            min_idx = n - min_idx - 1;
            is_decreasing = checkIfIncreasing(nums, min_idx, n);
            min_idx = temp1;
            for (int i = 0; i < n / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[n - 1 - i];
                nums[n - 1 - i] = temp;
            }

        }

        if (!is_increasing && !is_decreasing) {
            return -1;
        }

        int min_ops = n;
        if (is_increasing) {
            min_ops = Math.min(min_idx, 2 + n - min_idx);
        } else {
            min_ops = Math.min((2 + min_idx), (n - min_idx));
        }

        return min_ops;
    }

    public static void main(String[] args) {
        int nums[] = {1, 0, 6, 5, 4, 3, 2};
        L3942 l3942 = new L3942();
        int ans = l3942.minOperations(nums);
        System.out.println("Minimum number of operations required are : " + ans);
    }


}
