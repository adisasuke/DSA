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

//
//Given a string of digits s, return the number of palindromic subsequences of s having length 5. Since the answer may be very large, return it modulo 109 + 7.
//
//Note:
//
//A string is palindromic if it reads the same forward and backward.
//A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
//
//
//Example 1:
//
//Input: s = "103301"
//Output: 2
//Explanation:
//There are 6 possible subsequences of length 5: "10330","10331","10301","10301","13301","03301".
//Two of them (both equal to "10301") are palindromic.
//Example 2:
//
//Input: s = "0000000"
//Output: 21
//Explanation: All 21 subsequences are "00000", which is palindromic.
//        Example 3:
//
//Input: s = "9999900000"
//Output: 2
//Explanation: The only two palindromic subsequences are "99999" and "00000".
//
//
//Constraints:
//
//        1 <= s.length <= 104
//s consists of digits.
