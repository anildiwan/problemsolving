package com.adinc.largestpalindromicsubstring;

public class Solution {

    public static void main(String[] args) {
        final String input = args [0];

        int longestPalindromeLength = 1;

        if (isPallindrome(input))
            System.out.println("Longest pallindrome length is " + input.length());

        for (int i= 0; i < input.length(); i++) {

            int tempLength = findLongestPallindromeLength(input.charAt(i), input.substring(i));

            if (tempLength > longestPalindromeLength)
                longestPalindromeLength = tempLength;
        }

        System.out.println("Longest pallindrome length is " + longestPalindromeLength);
    }

    private static int findLongestPallindromeLength(char charAt, String input) {

        String subStr = input.substring(input.indexOf(charAt), input.lastIndexOf(charAt) + 1);

        if (isPallindrome(subStr)) {
            return subStr.length();
        } else
            return findLongestPallindromeLength(charAt, subStr.substring(0, subStr.lastIndexOf(charAt) - 1));

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
