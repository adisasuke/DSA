package org.Aditya.segmentTree;

public class L3479 {
    private int st[];

    private void buildTree(int i, int l, int r, int baskets[]){

        if(l==r){
            st[i] = baskets[l];
            return;
        }

        int mid = l + (r-l)/2;


        buildTree(2*i+1, l, mid, baskets);
        buildTree(2*i+2, mid+1, r, baskets);


        st[i] = Math.max(st[2*i+1], st[2*i+2]);


    }

    private boolean find(int i, int l, int r, int val){

        if(st[i] < val){
            return false;
        }

        if(l==r){

            st[i] = -1;
            return true;
        }


        int mid = l + (r-l)/2;

        boolean placed;
        if(val <= st[2*i+1]){
            placed = find(2*i+1, l, mid, val);
        }else{
            placed = find(2*i+2, mid+1, r, val);
        }

        st[i] = Math.max(st[2*i+1], st[2*i+2]);

        return placed;
    }





    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        int n = fruits.length;
        st = new int[4*n];

        buildTree(0, 0, n-1, baskets);

        int unplaced=0;

        for(int fruit: fruits){

            if(!find(0, 0, n-1, fruit)){
                unplaced++;
            }

        }

        return unplaced;

    }
}
