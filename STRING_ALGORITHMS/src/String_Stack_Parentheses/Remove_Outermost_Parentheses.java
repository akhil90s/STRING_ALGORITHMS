package String_Stack_Parentheses;

import java.util.Stack;

public class Remove_Outermost_Parentheses {

	public static void main(String[] args) {

		String s = "(()())(())";
		String result_removeOuterParentheses = removeOuterParentheses(s);
		System.out.println(result_removeOuterParentheses);

	}

	
	public static String removeOuterParentheses(String s) {

		if (s == null || s.isEmpty())
			return s;

		Stack<Character> stack = new Stack<>();
		int start = 0, end = 0, index = 0;
		String temp = "";
		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(c);
				index++;
			} else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
				index++;
			}
			if (stack.isEmpty()) {
				start = end;
				end = index;
				temp = s.substring(start, end);
				sb.append(temp.substring(1, temp.length() - 1));
			}
		}
		return sb.toString();
		
	}

}
