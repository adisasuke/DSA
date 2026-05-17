package org.Aditya.strings.Palindrome;

public class L214 {

    int lps[];


    private void constructLPS(String s){

        int n = s.length();
        lps = new int[n];

        int len = 0;
        int i = 1;

        while(i<n){

            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{

                if(len>0){
                    len = lps[len-1];
                }else{
                    i++;
                }

            }

        }


    }



    public String shortestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        String str = s + "_" + rev;

        constructLPS(str);

        int n = s.length();

        int len = lps[2*n];

        return rev.substring(0, n - len) + s;



    }

    public static void main(String[] args) {
        String str = "abcd";
        L214 l214 = new L214();
        String shortestPalindrom = l214.shortestPalindrome(str);

        System.out.println("Shortest palindrome is : " + shortestPalindrom);
    }
}

//
//You are given a string s. You can convert s to a palindrome by adding characters in front of it.
//
//Return the shortest palindrome you can find by performing this transformation.
//
//
//
//        Example 1:
//
//Input: s = "aacecaaa"
//Output: "aaacecaaa"
//Example 2:
//
//Input: s = "abcd"
//Output: "dcbabcd"
//
//
//Constraints:
//
//        0 <= s.length <= 5 * 104
//s consists of lowercase English letters only.