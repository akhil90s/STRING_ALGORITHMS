package String_Window_Slicing_Technique;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_With_At_Least_K_Repeating_Characters {

	public static void main(String[] args) {

		String s = "ababdebaacd";
		int result_longestSubstring = longestSubstring(s, 2);
		System.out.println(result_longestSubstring);

	}

	public static int longestSubstring(String s, int k) {

		int n = s.length();
		if (n == 0 || n < k)
			return 0;
		if (k <= 1)
			return n;

		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		
		int index = 0;
		while (index < n && map.get(s.charAt(index)) >= k)
			index++;

		if (index >= n - 1)
			return index;

		int ls1 = longestSubstring(s.substring(0, index), k);
		while (index < n && map.get(s.charAt(index)) < k)
			index++;
		int ls2 = (index < n) ? longestSubstring(s.substring(index), k) : 0;

		return Math.max(ls1, ls2);
	}

}
