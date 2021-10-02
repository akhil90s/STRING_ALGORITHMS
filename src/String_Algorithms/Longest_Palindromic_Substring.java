package String_Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Longest_Palindromic_Substring {

    // https://leetcode.com/problems/longest-palindromic-substring/
    public static void main(String[] args) {

        // String s = "sabababada";
        String s = "racecar";
        
        String result_1 = longestPalindrome_Approach1(s);
        System.out.println(result_1);
        
        String result_2 = longestPalindrome_Approach2(s);
        System.out.println(result_2);

    }

    // Brute Force Technique
    public static String longestPalindrome_Approach1(String s) {

        Set<String> set = new HashSet<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (!set.contains(temp) && isPalidrome(temp)) {
                    set.add(temp);
                }
            }
        }
        List<String> list = new ArrayList<String>(set);
        Collections.sort(list, Comparator.comparing(String::length));

        return list.get(list.size() - 1);
    }

    private static boolean isPalidrome(String s) {

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome_Approach2(String s) {

        if (s == null || s.length() < 1)
            return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            
            int len1 = expandFromMiddle(s,i , i);
            int len2 = expandFromMiddle(s, i, i+1);
            int len = Math.max(len1, len2);
            
            if(len > end - start) {
                start = i - ((len -1)/2);
                end = i + len/2;
            }
        }
        return s.substring(start, end +1);

    }

    public static int expandFromMiddle(String s, int left, int right) {

        if (s == null || left > right)
            return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

}
