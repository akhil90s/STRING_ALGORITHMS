package String_Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluate_The_Bracket_Pairs_Of_A_String {

    public static void main(String[] args) {

        String s = "(name)is(age)yearsold";

        List<List<String>> knowledge = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("name");
        list1.add("bob");

        List<String> list2 = new ArrayList<>();
        list2.add("age");
        list2.add("two");

        knowledge.add(list1);
        knowledge.add(list2);

        String result = evaluate(s, knowledge);
        System.out.println(result);

    }

    // https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string
    public static String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> knowledgeMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (List<String> list : knowledge) {
            knowledgeMap.put(list.get(0), list.get(1));
        }

        int start = 0, end = 0;
        String newWord = null;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                start = i;
                while (s.charAt(i) != ')') {
                    i++;
                    end = i;
                }
                if (knowledgeMap.containsKey(s.substring(start + 1, end))) {
                    newWord = knowledgeMap.get(s.substring(start + 1, end));
                    sb.append(newWord);
                } else {
                    sb.append("?");
                }

            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

}
