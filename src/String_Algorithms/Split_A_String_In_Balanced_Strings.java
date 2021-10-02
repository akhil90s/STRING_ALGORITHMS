package String_Algorithms;

public class Split_A_String_In_Balanced_Strings {

	// https://leetcode.com/problems/split-a-string-in-balanced-strings/
	public static void main(String[] args) {

		int result = balancedStringSplit("RLRRLLRLRL");
		System.out.println(result);

	}

	// RL RRLL RL RL
	public static int balancedStringSplit(String s) {

		int result = 0;
		char[] array = s.toCharArray();
		int lCount = 0;
		int rCount = 0;

		for (char c : array) {

			if (c == 'L')
				lCount++;
			if (c == 'R')
				rCount++;

			if (lCount == rCount) {

				result++;
				lCount = 0;
				rCount = 0;

			}
		}

		return result;

	}

}
