package org.Aditya.binaryLifting;

public class L1483 {

    int row;
    int col;
    int up[][];



    public L1483(int n, int[] parent) {

        row = n;
        col = (int)(Math.log(n)/Math.log(2)) + 1;

        up = new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                up[i][j] = -1;
            }
        }

        for(int i=0;i<parent.length;i++){

            up[i][0] = parent[i];

        }

        for(int j=1;j<col;j++){

            for(int i=0;i<row;i++){

                int prev = up[i][j-1];

                if(prev!=-1){
                    up[i][j] = up[prev][j-1];
                }


            }



        }



    }

    public int getKthAncestor(int node, int k) {

        for(int i=col-1;i>=0;i--){

            if(((k>>i)&1 )> 0){
                node = up[node][i];
                if(node == -1){
                    return -1;
                }

            }


        }

        return node;

    }
}
