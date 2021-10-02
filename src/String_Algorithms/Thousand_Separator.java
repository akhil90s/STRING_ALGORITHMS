package String_Algorithms;

public class Thousand_Separator {

    // https://leetcode.com/problems/thousand-separator/
    public static void main(String[] args) {

        String result = thousandSeparator(123456789);
        System.out.println(result);

    }

    public static String thousandSeparator(int n) {

        if (n == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int rem = 0;

        while (n != 0) {
            rem = n % 10;
            n = n / 10;
            i++;
            if (i % 3 == 0 && n != 0) {
                sb.insert(0, "." + rem);
            } else {
                sb.insert(0, rem);
            }
        }

        return sb.toString();
    }

}
