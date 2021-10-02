package String_Algorithms;

public class Longest_Common_Prefix {

    public static void main(String[] args) {

        String[] array = { "flow", "flowers", "flight" };
        //String result = longestCommonPrefix_BruteFore(array);
        String result = longestCommonPrefix(array);
        
        System.out.println(result);
        System.out.println("Akhil".indexOf("Akh"));
        
    }

    public static String longestCommonPrefix_BruteFore(String[] array) {

        if (array.length == 0)
            return "";
        
        String prefix = array[0];
        for (int i = 0; i < array.length; i++) {
            
            String s = array[i];
            int a = 0, b = 0;
            
            while (a < prefix.length() && b < s.length()) {
                if(prefix.charAt(a) != s.charAt(b)) {
                    break;
                }
                a++;
                b++;
            }
            
            prefix = prefix.substring(0, a);
        }

        return prefix;
    }

    public static String longestCommonPrefix(String[] array) {

        if (array.length == 0)
            return "";

        String prefix = array[0];

        for (String s : array) {
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

}
