package org.Aditya.segmentTree;

public class L307 {
    int st[];
    int n;

    private void buildTree(int i, int l, int r, int nums[]){

        if(l==r){
            st[i] = nums[l];
            return;
        }

        int mid = l + (r-l)/2;

        buildTree(2*i+1, l, mid, nums);
        buildTree(2*i+2, mid+1, r, nums);

        st[i] = st[2*i+1] + st[2*i+2];


    }



    public L307(int[] nums) {

        n = nums.length;
        st = new int[4*n];
        buildTree(0, 0, n-1, nums);
    }

    private void update(int index, int val, int i, int l, int r){

        if(l==r){
            st[i] = val;
            return;
        }

        int mid = l + (r-l)/2;

        if(index <= mid){
            update(index, val, 2*i+1, l, mid);
        }else{
            update(index, val, 2*i+2, mid+1, r);
        }

        st[i] = st[2*i+1] + st[2*i+2];
    }




    public void update(int index, int val) {
        update(index, val, 0, 0, n-1);
    }


    private int find(int start, int end, int i, int l, int r){

        if(r<start || l>end){
            return 0;
        }

        if(l>=start && r<=end){
            return st[i];
        }

        int mid = l + (r-l)/2;

        int leftSum = find(start, end, 2*i+1, l, mid);
        int rightSum = find(start, end, 2*i+2, mid+1, r);

        return leftSum+rightSum;

    }




    public int sumRange(int left, int right) {
        return find(left, right, 0, 0, n-1);
    }
}
