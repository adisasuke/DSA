package org.Aditya.segmentTree;

import java.util.HashMap;
import java.util.Map;

public class L2179 {

    private int st[];

    private void update(int i, int l, int r, int idx){

        if(l==r){
            st[i] += 1;
            return;
        }

        int mid = l + (r-l)/2;


        if(idx<=mid){
            update(2*i+1, l, mid, idx);
        }else{
            update(2*i+2, mid+1, r, idx);
        }

        st[i] = st[2*i+1] + st[2*i+2];


    }

    private int find(int start, int end, int i, int l, int r){

        if(r<start || l>end){
            return 0;
        }

        if(l>=start && r<=end){
            return st[i];
        }

        int mid = l + (r-l)/2;

        int left = find(start, end, 2*i+1, l, mid);
        int right = find(start, end, 2*i+2, mid+1, r);

        return left+right;

    }





    public long goodTriplets(int[] nums1, int[] nums2) {

        int n = nums1.length;
        st = new int[4*n];

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0;i<n;i++){

            mp.put(nums2[i], i);

        }

        int index = mp.get(nums1[0]);

        update(0, 0, n-1, index);

        long ans = 0;

        for(int i=1;i<n-1;i++){

            int idx = mp.get(nums1[i]);

            int leftCommon = find(0, idx, 0, 0, n-1);
            int leftUncommon = i - leftCommon;
            int right = n - 1 - idx;
            int rightCommon = right - leftUncommon;

            ans = ans + 1l*leftCommon*rightCommon;

            update(0, 0, n-1, idx);
        }

        return ans;

    }
}
