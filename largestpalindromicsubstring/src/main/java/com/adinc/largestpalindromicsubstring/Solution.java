package com.adinc.largestpalindromicsubstring;

public class Solution {

    public static void main(String[] args) {
        final String input = args [0];

        String longestPalindrome = null;

        if (isPallindrome(input))
            System.out.println(input + ", " + input.length());

        for (int i = 0; i < input.length(); i++)
            System.out.println(isPallindrome(null));
    }

    public static boolean isPallindrome (String input) {

        if (input == null)
            return false;

        final StringBuilder sb = new StringBuilder(input);

        if (sb.equals(sb.reverse()))
            return true;
        return false;


    }

}
