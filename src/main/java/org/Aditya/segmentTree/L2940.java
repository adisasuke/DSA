package org.Aditya.segmentTree;

public class L2940 {
    private int st[];
    int n;

    private void buildTree(int i, int l, int r, int heights[]){

        if(l==r){
            st[i] = l;
            return;
        }

        int mid = l + (r-l)/2;

        buildTree(2*i+1, l, mid, heights);
        buildTree(2*i+2, mid+1, r, heights);

        int leftIdx = st[2*i+1];
        int rightIdx = st[2*i+2];

        if(heights[leftIdx]>=heights[rightIdx]){
            st[i] = leftIdx;
        }else{
            st[i] = rightIdx;
        }

    }

    private int find(int start, int end, int i, int l, int r, int heights[]){


        if(r<start || l>end){
            return -1;
        }


        if(l>=start && r<=end){
            return st[i];
        }

        int mid = l + (r-l)/2;

        int leftIdx = find(start, end, 2*i+1, l, mid, heights);
        int rightIdx = find(start, end, 2*i+2, mid+1, r, heights);

        if(leftIdx == -1) return rightIdx;
        if(rightIdx == -1) return leftIdx;


        if(heights[leftIdx] >=heights[rightIdx]){
            return leftIdx;
        }

        return rightIdx;


    }

    private int find(int a, int b, int heights[]){


        int ret = -1;

        int low = b+1;
        int high = n-1;

        while(low<=high){

            int mid = low + (high-low)/2;

            int idx = find(low, mid, 0, 0, n-1, heights);



            if(heights[idx] > heights[a]){

                ret = idx;
                high = mid - 1;


            }
            else{
                low = mid + 1;
            }


        }

        return ret;

    }







    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {

        n = heights.length;
        st = new int[4*n];
        buildTree(0, 0, n-1, heights);

        int ans[] = new int[queries.length];

        for(int i=0;i<queries.length;i++){


            int a = queries[i][0];
            int b = queries[i][1];

            if(a==b){
                ans[i] = a;
                continue;
            }

            if(a>b){
                int t = a;
                a = b;
                b = t;
            }

            if(heights[b] > heights[a]){
                ans[i] = b;
                continue;
            }

            ans[i] = find(a, b, heights);


        }


        return ans;

    }
}
