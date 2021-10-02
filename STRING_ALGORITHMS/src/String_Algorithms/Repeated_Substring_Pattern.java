package String_Algorithms;

public class Repeated_Substring_Pattern {

    
    // https://leetcode.com/problems/repeated-substring-pattern
    public static void main(String[] args) {

        // boolean result = repeatedSubstringPattern("ababba");
        // boolean result = repeatedSubstringPattern_OneLiner("abcabcabcabc");
        boolean result = repeatedSubstringPattern_LeetCode("abcabcabc");
        System.out.println(result);

    }

    // Works fine only takes more time as per leetcode submission screen
    public static boolean repeatedSubstringPattern(String s) {

        if (s.length() > 10000 || s.length() < 1)
            return false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= s.length()/2; i++) {
            sb.append(s.charAt(i));
            StringBuilder temp = new StringBuilder(sb);

            while (!temp.toString().equals(s) & temp.length() < s.length()) {
                temp.append(sb);
                if (temp.toString().length() <= s.length()) {
                    if (!temp.toString().equals(s.substring(0, temp.length()))) {
                        break;
                    }
                    if (temp.toString().length() == s.length())
                        return true;
                }
            }
        }
        return false;
    }

    // Leetcode Solution
    public static boolean repeatedSubstringPattern_LeetCode(String s) {

        int length = s.length();

        for (int i = length / 2; i >= 1; i--) {
            if (length % i == 0) {
                int num_repeats = length / i;
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < num_repeats; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s))
                    return true;
            }

        }

        return false;
    }

    // One Liner Solution
    public static boolean repeatedSubstringPattern_OneLiner(String s) {

        return (s.substring(1) + s.substring(0, s.length() - 1)).contains(s);

    }

}
