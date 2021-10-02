package String_Stack;

import java.util.Stack;

public class Minimum_Add_To_Make_Parentheses_Valid {

	public static void main(String[] args) {
		
		String s = "()))((";
		int result_minAddToMakeValid = minAddToMakeValid(s);
		System.out.println(result_minAddToMakeValid);
		
	}

	public static int minAddToMakeValid(String s) {

		if (s == null || s.isEmpty())
			return 0;

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {

			if (c == '(') {
				stack.push(c);
			} else {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}
		
		return stack.size();
	}

}
