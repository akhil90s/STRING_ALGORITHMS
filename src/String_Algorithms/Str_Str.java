package String_Algorithms;

public class Str_Str {

	// https://leetcode.com/problems/implement-strstr/
	public static void main(String[] args) {
		int result = strStr("hello", "ll");
		System.out.println(result);

	}

	// haystack = "hello", needle = "ll"
	public static int strStr(String haystack, String needle) {

		int result = haystack.indexOf(needle);
		return result;
	}

}
