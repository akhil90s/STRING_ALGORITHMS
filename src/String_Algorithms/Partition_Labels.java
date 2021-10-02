package String_Algorithms;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/partition-labels/
public class Partition_Labels {

    public static void main(String[] args) {
        
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(s);
        System.out.println(result);

    }

    public static List<Integer> partitionLabels(String s) {

        if (s == null || s.length() == 0)
            return null;

        List<Integer> result = new ArrayList<>();
        int[] last_indices = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last_indices[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last_indices[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
