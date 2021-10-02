package String_Algorithms;

public class Reverse_Vowels_In_A_String {

	// https://leetcode.com/problems/reverse-vowels-of-a-string/
	public static void main(String[] args) {
		
		reverseVowelsInAString("leetcode");
		reverseVowelsInAString("hello");

	}

	public static void reverseVowelsInAString(String s) {

		char[] array = s.toCharArray();
		int start_Pointer = 0;
		int end_Pointer = s.length() - 1;
		char temp;
		while (start_Pointer < end_Pointer) {

			if (!verifyVowel(array[start_Pointer])) {
				start_Pointer++;
			} else if (!verifyVowel(array[end_Pointer])) {  
				end_Pointer--;
			} else {
				temp = array[start_Pointer];
				array[start_Pointer] = array[end_Pointer];
				array[end_Pointer] = temp;

				start_Pointer++;
				end_Pointer--;
			}

		}
		System.out.println(String.valueOf(array));

	}

	private static boolean verifyVowel(char c) {
		return c == 'a' || c == 'u' || c == 'o' || c == 'i' || c == 'e' || c == 'A' || c == 'U' || c == 'O' || c == 'I'
				|| c == 'E';
	}

}
