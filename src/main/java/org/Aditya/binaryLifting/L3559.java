package org.Aditya.binaryLifting;

import java.util.ArrayList;
import java.util.List;

public class L3559 {

    int mod = (int)1e9+7;

    int depth[];
    int parent[][];
    List<Integer> adj[];
    int n;
    int cols;

    private void dfs(int node, int par){


        for(int x: adj[node]){

            if(x==par) continue;

            depth[x] = depth[node] + 1;
            parent[x][0] = node;
            dfs(x, node);

        }

    }

    private void buildAncestor(){


        for(int j=1;j<cols;j++){

            for(int node=0;node<n;node++){

                int prev = parent[node][j-1];

                if(prev!=-1){
                    parent[node][j] = parent[prev][j-1];
                }

            }


        }
    }


    private int lcs(int node1, int node2){


        if(depth[node2]>depth[node1]){

            int temp = node1;
            node1 = node2;
            node2 = temp;
        }

        int k = depth[node1] - depth[node2];

        for(int i=cols-1;i>=0;i--){

            if(((1<<i)&k) > 0){
                node1 = parent[node1][i];
            }


        }

        if(node1==node2){
            return node1;
        }


        for(int j=cols-1;j>=0;j--){

            if(parent[node1][j] == -1) continue;

            if(parent[node1][j]!=parent[node2][j]){

                node1 = parent[node1][j];
                node2 = parent[node2][j];

            }


        }


        return parent[node1][0];

    }








    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        n = edges.length+1;
        depth = new int[n];
        cols = (int)(Math.log(n)/Math.log(2)) + 1;
        parent = new int[n][cols];

        for(int i=0;i<n;i++){
            for(int j=0;j<cols;j++){
                parent[i][j] = -1;
            }
        }

        adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){

            int node1 = edges[i][0]-1;
            int node2 = edges[i][1]-1;
            adj[node1].add(node2);
            adj[node2].add(node1);
        }

        dfs(0, -1);
        buildAncestor();

        int[] pow = new int[n];
        pow[0] = 1;

        for(int i=1;i<n;i++){

            pow[i] =  (int)(2l * pow[i-1])%mod;

        }

        int ans[] = new int[queries.length];

        for(int i=0;i<queries.length;i++){

            int node1 = queries[i][0]-1;
            int node2 = queries[i][1]-1;

            int d1 = depth[node1];
            int d2 = depth[node2];


            int l = lcs(node1, node2);


            int d = d1 + d2 - 2*depth[l];


            if(d==0){
                ans[i] = 0;
            }else{
                ans[i] = pow[d-1];
            }


        }


        return ans;



    }
}
