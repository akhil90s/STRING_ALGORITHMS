package String_Algorithms;

public class Maximum_Repeating_Substring {

    public static void main(String[] args) {

        int result = maxRepeating_BruteForce("ababc", "ba");
        System.out.println(result);

    }
 
    
    // ababc
    public static int maxRepeating_BruteForce(String sequence, String word) {

        int maximum = 0;
        int count = 0;

        for (int i = 0; i < sequence.length(); i++) {
            count = 0;
            for (int j = i; j < sequence.length() - word.length() + 1; j = j + word.length()) {
                if (sequence.substring(i, j + word.length()).equals(word)) {
                    count++;
                    maximum = Math.max(maximum, count);
                    i = i + word.length();
                } else if (count > 0) {
                    i--;
                    break;
                } else {
                    break;
                }
            }
        }
        return maximum;
    }

}
