package String_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Get_All_Subsequence_Of_String {

	public static void main(String[] args) {

		String s = "abc";
		List<String> result_getAllSubsequence = getAllSubsequence(s);
		System.out.println(result_getAllSubsequence);

	}

	public static List<String> getAllSubsequence(String s) {

		if (s.length() == 0) {
			List<String> list = new ArrayList<>();
			list.add("");
			return list;
		}
		
		List<String> list = getAllSubsequence(s.substring(1));
		List<String> result = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			result.add(list.get(i));
			result.add(s.charAt(0) + list.get(i));
		}
		
		return result;
	}

}
