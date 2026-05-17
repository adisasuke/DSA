package org.Aditya.strings.Palindrome;

public class L647 {


    int count;

    private void check(int i, int j, String s){

        int n = s.length();

        while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
            count++;
            i--;
            j++;
        }

    }


    public int countSubstrings(String s) {
        int n = s.length();
        count=0;
        for(int i=0;i<n;i++){
            check(i, i, s);
            check(i, i+1, s);
        }

        return count;
    }


//    public int countSubstrings(String s) {
//
//        int n = s.length();
//
//        boolean t[][] = new boolean[n][n];
//
//
//        int count = 0;
//
//        for(int l=1;l<=n;l++){
//
//            for(int i=0;i+l-1<n;i++){
//
//                int j = i+l-1;
//
//                if(i==j){
//                    t[i][j] = true;
//                }
//                else if((i+1) == j){
//                    if(s.charAt(i)==s.charAt(j)){
//                        t[i][j] = true;
//                    }
//                }
//                else if(s.charAt(i)==s.charAt(j) && t[i+1][j-1]==true){
//                    t[i][j] = true;
//                }
//
//                if(t[i][j]==true){
//                    count++;
//                }
//
//            }
//
//        }
//
//        return count;
//    }

    public static void main(String[] args) {
        String str = "aaa";
        L647 l647 = new L647();
        int ans = l647.countSubstrings(str);
        System.out.println("Substrings count is : " + ans);
    }



}



//Given a string s, return the number of palindromic substrings in it.
//
//A string is a palindrome when it reads the same backward as forward.
//
//A substring is a contiguous sequence of characters within the string.
//
//
//
//        Example 1:
//
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
//Example 2:
//
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//
//
//Constraints:
//
//        1 <= s.length <= 1000
//s consists of lowercase English letters.