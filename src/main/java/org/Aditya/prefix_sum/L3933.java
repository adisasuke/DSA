package org.Aditya.prefix_sum;

public class L3933 {


    int prefix[][][];

    private int check(int x ,int r1, int c1, int r2, int c2){

        return prefix[x][r2+1][c2+1] - prefix[x][r1][c2+1] - prefix[x][r2+1][c1] + prefix[x][r1][c1];

    }


    public int countLocalMaximums(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        prefix = new int[201][n+1][m+1];

        for(int i=0;i<=200;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){


                    int cnt = matrix[j][k]>i ? 1:0;

                    prefix[i][j+1][k+1] = prefix[i][j][k+1] + prefix[i][j+1][k] - prefix[i][j][k] + cnt;

                }
            }


        }


        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                int x = matrix[i][j];

                if(x!=0){

                    int cnt = check(x, Math.max(0, i-x), Math.max(0, j-x), Math.min(n-1, i+x), Math.min(m-1, j+x));

                    int dir[][] = {
                            {i-x, j-x},
                            {i-x, j+x},
                            {i+x, j-x},
                            {i+x, j+x}
                    };

                    for(int d[]:dir){

                        int i1 = d[0];
                        int j1 = d[1];

                        if(i1>=0 && j1>=0 && i1<n && j1<m && matrix[i1][j1]>x){
                            cnt--;
                        }



                    }

                    if(cnt==0){
                        ans++;
                    }

                }


            }
        }


        return ans;



    }

    public static void main(String[] args) {
        L3933 l3933 = new L3933();

        int matrix[][] = {{0,0,0,0,0,0,0},
                       {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,2,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0}};




        int cnt = l3933.countLocalMaximums(matrix);

        System.out.println("Number of local maxima is : " + cnt);
    }
}
