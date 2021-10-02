package String_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Get_All_Substring_Of_String {

    public static void main(String[] args) {

        List<String> result = getAllSubstring("abcde");
        
        // List<String> result = getAllSubstring_Recursion("abc");

        printList(result);
    }

    // Declare a global list
    static List<String> result_recursion = new ArrayList<>();

    public static List<String> getAllSubstring(String s) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                result.add(s.substring(i, j));
            }
        }
        return result;

    }

    public static List<String> getAllSubstring_Recursion(String s) {
        
        findsubsequences(s, ""); // Calling a function
        return result_recursion;
        
    }

    private static void findsubsequences(String s, String ans) {
        
        if (s.length() == 0) {
            result_recursion.add(ans);
            return;
        }

        // We add adding 1st character in string
        findsubsequences(s.substring(1), ans + s.charAt(0));

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        findsubsequences(s.substring(1), ans);
    }

    public static void printList(List<String> result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
