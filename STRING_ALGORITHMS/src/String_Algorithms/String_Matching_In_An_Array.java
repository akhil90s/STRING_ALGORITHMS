package String_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class String_Matching_In_An_Array {

	// https://leetcode.com/problems/string-matching-in-an-array/
	public static void main(String[] args) {

		String[] array = new String[] { "mass", "as", "hero", "h", "superhero" };
		List<String> result = stringMatching(array);
		System.out.println(result);

	}

	// Brute Force Approach
	public static List<String> stringMatching(String[] words) {

		List<String> result = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {

			for (int j = 0; j < words.length; j++) {
				if (words[i].length() > words[j].length()) {
					continue;
				} else if (words[j].contains(words[i]) && i != j) {
					if (!result.contains(words[i]))
						result.add(words[i]);
				}
			}
		}
		return result;
	}
}
