package org.Aditya.strings.Palindrome;

public class L2484 {

    public int countPalindromes(String s) {

        int mod = (int)1e9+7;

        int n = s.length();

        int leftCount[] = new int[10];
        int rightCount[] = new int[10];

        int back[][] = new int[10][10];
        int front[][] = new int[10][10];


        for(int i=n-1;i>=0;i--){

            int num = s.charAt(i) - '0';

            for(int j=0;j<10;j++){

                if(leftCount[j]>0){

                    back[num][j] += leftCount[j];

                }


            }

            leftCount[num]++;

        }

        long res = 0;

        //1.)Remove backwards  , 2.)calculate ans  3.)increment forward
        for(int i=0;i<n;i++){

            int num = s.charAt(i) -'0';

            leftCount[num]--;

            for(int j=0;j<10;j++){

                if(leftCount[j]>0){

                    back[num][j] -= leftCount[j];


                }



            }

            for(int k1=0;k1<10;k1++){
                for(int k2=0;k2<10;k2++){

                    res = (res + (back[k1][k2]*1l * front[k1][k2]*1l)%mod)%mod;
                }
            }


            for(int j=0;j<10;j++){

                if(rightCount[j]>0){

                    front[num][j] += rightCount[j];

                }



            }

            rightCount[num]++;
        }

        return (int)res;
    }


    public static void main(String[] args) {

        L2484 l2484 = new L2484();

        String str = "103301";

        int ans  = l2484.countPalindromes(str);

        System.out.println("count is ans : " + ans);

    }
}

//Solution:
//https://www.youtube.com/watch?v=vW3l7UvYmwQ



