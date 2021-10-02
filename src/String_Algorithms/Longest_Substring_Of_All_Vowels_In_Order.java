package String_Algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Longest_Substring_Of_All_Vowels_In_Order {

    public static void main(String[] args) {

        // aeiaaioaaaaeiiiiouuuooaauuaeiu
        //aaeiiioou
        System.out.println("aaeiiioou".length());
        int result = longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu");
        System.out.println(result);

    }

    // a e i o u
    public static int longestBeautifulSubstring(String word) {
        
        if (word == null || word.length() < 5)
            return 0;
        
        int result = 0;
        int count = 1;
        Map<Character, Integer> map = mapOfVowels();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < word.length() - 1; i++) {
            if (map.get(word.charAt(i + 1)) - map.get(word.charAt(i)) == 1
                    || map.get(word.charAt(i + 1)) - map.get(word.charAt(i)) == 0) {
                    count++;
                    set.add(word.charAt(i));
                    set.add(word.charAt(i + 1));
                if (set.size() == 5) {
                    result = Math.max(count , result);
                }
            } else {
                count = 1;
                set = new HashSet<>();
            }
        }
        return result;
    }

    public static Map<Character, Integer> mapOfVowels() {

        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

        map.put('a', 1);
        map.put('e', 2);
        map.put('i', 3);
        map.put('o', 4);
        map.put('u', 5);

        return map;
    }

}
