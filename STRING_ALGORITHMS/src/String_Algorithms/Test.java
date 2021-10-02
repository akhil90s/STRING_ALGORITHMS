package String_Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        int[] a = new int[] { 100, 100, -10, -20, -30 };
        String[] d = new String[] { "2020-01-01", "2020-02-01", "2020-02-11", "2020-02-05", "2020-02-08" };

        int months = 12;
        int totalAmount = 0;

        Map<String, Integer> m1 = new HashMap<>();
        Map<String, List<Integer>> m2 = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int trans = a[i];
            String month = d[i].substring(5, 7);

            m1.put(month, m1.getOrDefault(month, 0) + trans);

            List<Integer> list = m2.getOrDefault(month, new ArrayList<Integer>());
            list.add(trans);
            m2.put(month, list);
        }

        for (Map.Entry<String, List<Integer>> entry : m2.entrySet()) {
            List<Integer> list = entry.getValue();
            int monthCount = 0;
            int totalMonthSum = 0;
            for (int i : list) {
                if (i < 0) {
                    monthCount++;
                    totalMonthSum += i;
                }
            }
            if (monthCount >= 3 && totalMonthSum <= -100) {
                months = months - 1;
            }
        }

        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            totalAmount += entry.getValue();
        }
        totalAmount -= (months * 5);

        System.out.println(totalAmount);

    }
}
