package String_Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Reorganize_String {

    public static void main(String[] args) {

        String s = "aab";
        String result_reorganizeString = reorganizeString(s);
        System.out.println(result_reorganizeString);

    }

    public static String reorganizeString(String s) {

        if (s == null || s.length() == 0)
            return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();

        while (maxHeap.size() > 1) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();
            sb.append(first).append(second);
            map.put(first, map.get(first) - 1);
            map.put(second, map.get(second) - 1);
            if (map.get(first) > 0)
                maxHeap.add(first);
            if (map.get(second) > 0)
                maxHeap.add(second);
        }

        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();
            if (map.get(last) > 1) {
                return "";
            }
            sb.append(last);
        }
        return sb.toString();
    }

}
