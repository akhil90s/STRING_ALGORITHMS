package String_Algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class The_First_Unique_Character {

    public static void main(String[] args) {

        char result = theFirstUniqueCharacter("aabmbrrddtssyon");
        System.out.println(result);

    }

    public static char theFirstUniqueCharacter(String s) {

        char[] array = s.toCharArray();
        Map<Character, Integer> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (resultMap.containsKey(array[i])) {
                resultMap.put(array[i], resultMap.get(array[i]) + 1);
            } else {
                resultMap.put(array[i], 1);
            }
        }

        for (Map.Entry<Character, Integer> map : resultMap.entrySet()) {
            if (map.getValue() == 1) {
                return map.getKey();
            }
        }
        return '_';
    }

}
