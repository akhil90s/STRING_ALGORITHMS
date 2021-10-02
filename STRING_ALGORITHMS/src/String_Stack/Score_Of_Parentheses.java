package String_Stack;

import java.util.Stack;

public class Score_Of_Parentheses {

	public static void main(String[] args) {

		String s = "(()(()))";
		int result_scoreOfParentheses = scoreOfParentheses(s);
		System.out.println(result_scoreOfParentheses);
	}

	public static int scoreOfParentheses(String s) {

		Stack<Integer> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			
			if (c == '(') {
				stack.push(-1);
			} else {
				if (stack.peek() == -1) {
					stack.pop();
					stack.push(1);
				} else {
					int val = 0;
					while(stack.peek() != -1) {
						val += stack.pop();
					}
					stack.pop();
					stack.push(val * 2);
				}
			}
		}
		int val = 0;
		while(stack.size() != 0) {
			val += stack.pop();
		}
		return val;
	}

}
