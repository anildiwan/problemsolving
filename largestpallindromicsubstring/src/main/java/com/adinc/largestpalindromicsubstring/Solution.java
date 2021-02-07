package com.adinc.largestpalindromicsubstring;

public class Solution {

    public static void main(String[] args) {
        System.out.println("Longest pallindrome length is " + longestPalindrome(args[0]));
    }

    public static String longestPalindrome(String s) {
        final String input = s;

        int longestPalindromeLength = 0;
        String longestPallindrome = null;

        if (isPallindrome(input))
            return input;

        for (int i= 0; i < input.length(); i++) {

            String temp = findLongestPallindrome(input.charAt(i), input.substring(i));
            int tempLength = temp.length();

            if (tempLength > longestPalindromeLength) {
                longestPallindrome = temp;
                longestPalindromeLength = tempLength;
            }
        }

        return longestPallindrome;
    }

    private static String findLongestPallindrome(char charAt, String input) {

        String subStr = input.substring(input.indexOf(charAt), input.lastIndexOf(charAt) + 1);

        if (isPallindrome(subStr)) {
            return subStr;
        } else
            return findLongestPallindrome(charAt, subStr.substring(0, subStr.lastIndexOf(charAt)));

    }


    public static boolean isPallindrome (String input) {

        if (input == null) {
            return false;
        }

        final StringBuilder sb = new StringBuilder(input);

        if (sb.toString().equals(sb.reverse().toString())) {
            return true;
        }
        return false;


    }
}
