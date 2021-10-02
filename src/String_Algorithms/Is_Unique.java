package String_Algorithms;

public class Is_Unique {

    public static void main(String[] args) {

        boolean result_1 = isUnique_Approach1("asdipqwae");
        System.out.println(result_1);
        boolean result_2 = isUnique_Approach2("asdi!2pqwe");
        System.out.println(result_2);

    }

    // Handles only alphabets
    public static boolean isUnique_Approach1(String s) {

        s.toLowerCase();
        int[] char_count = new int[26];
        for (char c : s.toCharArray()) {
            char_count[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (char_count[c - 'a'] > 1)
                return false;
        }
        return true;
    }

    public static boolean isUnique_Approach2(String s) {

        if (s.length() > 128)
            return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (char_set[c]) {
                return false;
            } else {
                char_set[c] = true;
            }
        }
        return true;
    }

}
