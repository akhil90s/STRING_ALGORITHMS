package String_Window_Slicing_Technique;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {

		String s = "abcabcbb";
		int result_lengthOfLongestSubstring = lengthOfLongestSubstring(s);
		System.out.println(result_lengthOfLongestSubstring);

	}

	public static int lengthOfLongestSubstring(String s) {
		
		if(s.length() == 0)
			return 0;
		
		Set<Character> set = new HashSet<>();
		int a_pointer = 0;
		int b_pointer = 0;
		int result = Integer.MIN_VALUE;
		int start = 0, end = 0;
		
		while(b_pointer < s.length()) {
			if(!set.contains(s.charAt(b_pointer))) {
				set.add(s.charAt(b_pointer));
				if(b_pointer - a_pointer + 1 > result) {
					result = b_pointer - a_pointer + 1;
					start = a_pointer;
					end = b_pointer;
				}
				b_pointer++;
			} else {
				set.remove(s.charAt(a_pointer));
				a_pointer++;
			}
		}
		System.out.println(s.substring(start, end + 1));
		return result;
	}

}
