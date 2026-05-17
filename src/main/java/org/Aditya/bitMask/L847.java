package org.Aditya.bitMask;

import java.util.ArrayDeque;
import java.util.Queue;

public class L847 {
    public int shortestPathLength(int[][] graph) {

        int n = graph.length;

        Queue<int[]> q = new ArrayDeque<>();


        for(int i=0;i<n;i++){

            int[]temp = {i, 1<<i};

            q.add(temp);

        }

        boolean vis[][] = new boolean[n][(1<<n)];


        int finalMask = (1<<n) - 1;

        int dist = -1;

        while(!q.isEmpty()){

            dist++;
            int sz = q.size();


            while(sz>0){

                int []temp = q.poll();

                int node = temp[0];
                int mask = temp[1];


                if(mask == finalMask){
                    return dist;
                }

                for(int x: graph[node]){

                    int tempMask = mask | (1<<x);

                    if(vis[x][tempMask]==true) continue;

                    vis[x][tempMask] = true;
                    q.add(new int[]{x, tempMask});

                }

                sz--;
            }

        }

        return -1;

    }

    public static void main(String[] args) {

        L847 l847 = new L847();

        int graph[][] = {
                {1, 2, 3},
                {0},
                {0},
                {0}
        };

        int ans = l847.shortestPathLength(graph);

        System.out.println("Total distance to cover all nodes: "+ ans);
    }



}

//graph = [[1,2,3],[0],[0],[0]]