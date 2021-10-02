package String_Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid_Parenthesis {

	public static void main(String[] args) {

		boolean result_isValid_Approach1 = isValid_Approach1("{()[]{}}");
		System.out.println(result_isValid_Approach1);
		
		boolean result_isValid_Approach2 = isValid_Approach2("{()[]{}}");
		System.out.println(result_isValid_Approach2);

	}

	public static boolean isValid_Approach1(String s) {
		Stack<Character> stack = new Stack<>();

		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		for (Character c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty() || stack.peek() != map.get(c))
					return false;
				stack.pop();
			}
		}

		return stack.isEmpty();
	}

	public static boolean isValid_Approach2(String s) {

		if(s.length() % 2 != 0)
			return false;
		Stack<Character> stack = new Stack<>();
		
		for(char c : s.toCharArray()) {
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}


