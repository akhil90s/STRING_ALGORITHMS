package String_Window_Slicing_Technique;

public class Longest_Repeating_Character_Replacement {

	public static void main(String[] args) {

		String s = "AABABBA";
		int result_characterReplacement = characterReplacement(s, 1);
		System.out.println(result_characterReplacement);

	}

	public static int characterReplacement(String s, int k) {

		int n = s.length();
		int[] char_count = new int[26];

		int window_start = 0;
		int max_count = 0;
		int max_length = 0;

		for (int window_end = 0; window_end < n; window_end++) {
			char_count[s.charAt(window_end) - 'A']++;
			int current_char_count = char_count[s.charAt(window_end) - 'A'];
			max_count = Math.max(max_count, current_char_count);
			
			while (window_end - window_start - max_count + 1 > k) {
				char_count[s.charAt(window_start) - 'A']--;
				window_start++;
			}
			
			max_length = Math.max(max_length, window_end - window_start + 1);
		}

		return max_length;
	}

}
