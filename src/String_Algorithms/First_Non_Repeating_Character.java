package String_Algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class First_Non_Repeating_Character {

    public static void main(String[] args) {

        // char result = firstNonRepeatingCharacter_BruteForce("aabbrrddptss");
        // char result = firstNonRepeatingCharacter_LinkedHashMap("aabmbrrddptss");
        char result = firstNonRepeatingCharacter_ASCII("aabbrrddtss");
        // char result = firstNonRepeatingCharacter_Methods("aabbrrddtss");
        System.out.println(result);

    }

    // Brute Force
    public static char firstNonRepeatingCharacter_BruteForce(String s) {

        boolean seenDuplicate = false;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            seenDuplicate = false;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    seenDuplicate = true;
                    break;
                }
            }
            if (!seenDuplicate)
                return array[i];
        }
        return '_';
    }

    // Using HashMap
    public static char firstNonRepeatingCharacter_LinkedHashMap(String s) {
        Map<Character, Integer> characterMap = new LinkedHashMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (characterMap.containsKey(array[i])) {
                characterMap.put(array[i], characterMap.get(array[i]) + 1);
            } else {
                characterMap.put(array[i], 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '_';
    }

    // ASCII
    public static char firstNonRepeatingCharacter_ASCII(String s) {

        int[] char_count = new int[26];

        for (char c : s.toCharArray())
            char_count[c - 'a']++;

        for (char c : s.toCharArray())
            if (char_count[c - 'a'] == 1)
                return c;

        return '_';
    }

    // Built-In Methods
    public static char firstNonRepeatingCharacter_Methods(String s) {

        char[] array = s.toCharArray();
        for (char c : array) {
            if (s.indexOf(c) == s.lastIndexOf(c))
                return c;
        }
        return '_';
    }

}
