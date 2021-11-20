package String_Stack_Parentheses;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_Substrings_Between_Each_Pair_Of_Parentheses {

	public static void main(String[] args) {
		
		String s = "(u(love)i)";
		String result_reverseParentheses = reverseParentheses(s);
		System.out.println(result_reverseParentheses);

	}

	public static String reverseParentheses(String s) {
		
		if(s == null || s.isEmpty())
			return null;
		
		Stack<Character> stack = new Stack<>();
		for(char c : s.toCharArray()) {
			if(c == ')') {
				Queue<Character> queue = new LinkedList<>();
				while(stack.peek() != '(') {
					queue.offer(stack.pop());
				}
				stack.pop();
				while(queue.size() !=  0) {
					stack.push(queue.poll());
				}
			}else {
				stack.push(c);
			}
		}
		
		char[] array = new char[stack.size()];
		int index = array.length - 1;
		while(index >= 0) {
			array[index] = stack.pop();
			index--;
		}
		
		return new String(array);
		
	}

}
