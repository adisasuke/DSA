package org.Aditya.strings.KMP;

public class KMP {

    int lps[];

    private void constructLPS(String needle){

        int m = needle.length();

        int i = 1;
        int length = 0;

        while(i<m){

            if(needle.charAt(i) == needle.charAt(length)){
                length++;
                lps[i] = length;
                i++;
            }else{

                if(length==0){
                    i++;
                }else{
                    length = lps[length-1];
                }


            }


        }


    }



    public int solveKMP(String haystack, String needle) {


        int n = haystack.length();
        int m = needle.length();

        lps = new int[m];

        constructLPS(needle);

        int i = 0;
        int j = 0;


        while(i<n){

            char ch1 = haystack.charAt(i);
            char ch2 = needle.charAt(j);

            if(ch1==ch2){
                i++;
                j++;

            }

            if(j == m){
                return (i-m);
            }
            else if(i<n && haystack.charAt(i)!=needle.charAt(j)){

                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }



            }

        }

        return -1;


    }


    public static void main(String args[]){

        KMP kmp = new KMP();

        String haystack = "sadbutsad";
        String needle = "sad";

        int ind = kmp.solveKMP(haystack, needle);
        System.out.println("Index at which they match in haystack is : "+ ind);

    }



}
