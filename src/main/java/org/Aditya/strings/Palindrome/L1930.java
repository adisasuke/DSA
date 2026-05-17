package org.Aditya.strings.Palindrome;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L1930 {

    public int countPalindromicSubsequence(String s) {

        int n = s.length();

        int firstSeen[] = new int[26];
        Arrays.fill(firstSeen, Integer.MAX_VALUE);

        int lastSeen[] = new int[26];

        int res = 0;

        for(int i=0;i<n;i++){

            char ch = s.charAt(i);

            firstSeen[ch-'a'] = Math.min(firstSeen[ch-'a'], i);

            lastSeen[ch-'a'] = i;

        }

        for(int i=0;i<26;i++){

            if(firstSeen[i] >= lastSeen[i]) continue;


            int start = firstSeen[i]+1;
            int end = lastSeen[i]-1;

            Set<Character> st = new HashSet<>();

            for(int k=start;k<=end;k++){
                st.add(s.charAt(k));
            }

            res += st.size();

        }

        return res;
    }

    public static void main(String[] args) {

        L1930 l1930 = new L1930();
        String str = "aabca";
        int ans = l1930.countPalindromicSubsequence(str);
    }
}




//Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
//
//Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
//
//A palindrome is a string that reads the same forwards and backwards.
//
//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//
//For example, "ace" is a subsequence of "abcde".
//
//
//Example 1:
//
//Input: s = "aabca"
//Output: 3
//Explanation: The 3 palindromic subsequences of length 3 are:
//        - "aba" (subsequence of "aabca")
//        - "aaa" (subsequence of "aabca")
//        - "aca" (subsequence of "aabca")
//Example 2:
//
//Input: s = "adc"
//Output: 0
//Explanation: There are no palindromic subsequences of length 3 in "adc".
//Example 3:
//
//Input: s = "bbcbaba"
//Output: 4
//Explanation: The 4 palindromic subsequences of length 3 are:
//        - "bbb" (subsequence of "bbcbaba")
//        - "bcb" (subsequence of "bbcbaba")
//        - "bab" (subsequence of "bbcbaba")
//        - "aba" (subsequence of "bbcbaba")
//
//
//Constraints:
//
//        3 <= s.length <= 105
//s consists of only lowercase English letters.