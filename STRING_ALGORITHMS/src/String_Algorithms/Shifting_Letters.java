package String_Algorithms;

public class Shifting_Letters {

    // https://leetcode.com/problems/shifting-letters/
    public static void main(String[] args) {

        String s = "abcd";
        int[] shifts = new int[] { 3, 5, 9, 1 };
        // String result = shiftingLetters_Approach1(s, shifts);
        String result = shiftingLetters_Approach2(s, shifts);
        System.out.println(result);

    }

    // Time Complexity = O(n2)
    public static String shiftingLetters_Approach1(String s, int[] shifts) {

        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(s);
        int temp = 0;
        int newAlphabet = 0;
        for (int i = 0; i < s.length(); i++) {
            temp = shifts[i];
            for (int j = 0; j <= i; j++) {
                newAlphabet = (alphabets.indexOf(sb.charAt(j)) + temp) % 26;
                sb.replace(j, j + 1, String.valueOf(alphabets.charAt(newAlphabet)));
            }
        }
        return sb.toString();
    }

    // Time Complexity = O(n)
    public static String shiftingLetters_Approach2(String S, int[] shifts) {

        int previous = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            shifts[i] = (shifts[i] + previous) % 26;
            previous = shifts[i];
        }
        StringBuilder res = new StringBuilder(S);
        for (int i = 0; i < S.length(); i++) {
            res.setCharAt(i, (char) ((S.charAt(i) - 'a' + shifts[i]) % 26 + 'a'));
        }

        return res.toString();
    }

}
