package easy;
/**
 * https://leetcode.com/problems/roman-to-integer/
 */

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    public static void main(String[] args) {
        String q = "LVIII";

        System.out.println(new RomantoInteger().romanToInt20230214_2(q));
    }


    public int romanToInt20230214(String s) {
        /**
         * I(73) - V(86)X(88)
         * X(88) - L(76)C(67)
         * C(67) -D(68)M(77)
         */
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char last = 0;
        int diff;
        int pm = 1;
        int sum = 0;
        char c;
        for (int i = s.length() - 1; i >= 0; i--) {
            c = s.charAt(i);
            if (last != 0) {
                diff = c - last;
                pm = diff == -13 || diff == -15 ||
                        diff == 12 || diff == 21 ||
                        diff == -1 || (diff == -10 && c != 76) ?
                        -1 : 1;
            }

            last = c;
            sum += map.get(c) * pm;
        }

        return sum;
    }

    public int romanToInt20230214_2(String s) {
        /**
         * I(73) - V(86)X(88)
         * X(88) - L(76)C(67)
         * C(67) -D(68)M(77)
         */
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char last = 0;
        int pm = 1;
        int sum = 0;
        char c;
        for (int i = s.length() - 1; i >= 0; i--) {
            c = s.charAt(i);
            pm = last != 0 && map.get(c) < map.get(last) ? -1 : 1;
            last = c;
            sum += map.get(c) * pm;
        }

        return sum;
    }

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        String[] values = s.split("");
        int count = 0;
        int next;
        String current;
        int sum = 0;
        String combine = null;
        while (count < values.length) {
            next = count + 1;
            current = next < values.length ? values[count] + values[next] : values[count];
            if (map.get(current) == null) {
                current = values[count];
            } else {
                count = next;
            }

            sum += map.get(current);
            count++;
        }

        return sum;
    }

    public int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int next;
        int plusOrMinus = 1;
        int length = s.toCharArray().length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            next = i + 1;
            if (next < length && map.get(s.charAt(i)) < map.get(s.charAt(next))) {
                plusOrMinus = -1;
            } else {
                plusOrMinus = 1;
            }

            sum += map.get(s.charAt(i)) * plusOrMinus;
        }

        return sum;
    }


}
