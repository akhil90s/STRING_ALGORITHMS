package String_Algorithms;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Longest_Distinct_SubString_Without_Any_Repeating_Character {

    
    
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public static void main(String[] args) {

        int result_1 = longestDistinctSubString_Technique1("GEEKSFORGEEKS");
        System.out.println(result_1);

        int result_2 = longestDistinctSubString_Technique2("GEEKSFORGEEKS");
        System.out.println(result_2);

    }

    // Window Slicing Technique
    public static int longestDistinctSubString_Technique1(String s) {

        int a_pointer = 0;
        int b_pointer = 0;
        int n = s.length();
        int max = Integer.MIN_VALUE;

        String result = "";

        Set<Character> set = new HashSet<Character>();
        while(b_pointer< n) {
            if(!set.contains(s.charAt(b_pointer))) {
                set.add(s.charAt(b_pointer));
                b_pointer++;
                if (max < Math.max(max, set.size())) {
                    max = Math.max(max, set.size());
                    result = s.substring(a_pointer, b_pointer);
                }
            }else {
                set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        System.out.println(result);
        return max;
    }

    // Acquire until becomes invalid, release until it becomes valid. Similar to
    // Window Sliding Technique
    public static int longestDistinctSubString_Technique2(String s) {
        // a a b a a b!bb

        if (s.isEmpty() || s == null)
            return 0;

        int a_pointer = 0;
        int b_pointer = 0;
        int n = s.length();
        int max = Integer.MIN_VALUE;

        Map<Character, Integer> map = new LinkedHashMap<>();
        while (b_pointer < n) {
            if (map.containsKey(s.charAt(b_pointer))) {
                a_pointer = longestDistinctSubString_Technique2_HelperMethod(map, a_pointer, b_pointer, s);
            } else {
                map.put(s.charAt(b_pointer), 1);
                max = Math.max(max, map.size());
                b_pointer++;
            }
        }
        return max;
    }

    public static int longestDistinctSubString_Technique2_HelperMethod(Map<Character, Integer> map, int a_pointer,
            int b_pointer, String s) {

        while (a_pointer < b_pointer && map.containsKey(s.charAt(b_pointer))) {
            map.remove(s.charAt(a_pointer));
            a_pointer++;
        }

        return a_pointer;
    }

}
