package easy;
/**
 * https://leetcode.com/problems/valid-parentheses/
 */

import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String q = "{}";
        System.out.println(new ValidParentheses().isValid2(q));
    }

    public boolean isValid(String s) {
        /**
         * Runtime: 58 ms, faster than 5.13% of Java online submissions for Valid Parentheses.
         * Memory Usage: 53.9 MB, less than 6.57% of Java online submissions for Valid Parentheses
         */
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }

        String a = "()";
        String b = "[]";
        String c = "{}";
        int count = 0;
        while (true) {
            if (count >= length / 2) {
                break;
            }
            s = s.replace(a, "");
            s = s.replace(b, "");
            s = s.replace(c, "");
            count++;
        }

        return s.equals("");


    }

    /**
     *
     Runtime: 77 ms, faster than 5.21% of Java online submissions for Valid Parentheses.
     Memory Usage: 41.6 MB, less than 81.66% of Java online submissions for Valid Parentheses.

     */
    public boolean isValid2(String s) {
        String[] bracket1 = {"[", "]"};
        String[] bracket2 = {"(", ")"};
        String[] bracket3 = {"{", "}"};
        String[] split = s.split("");

        if (split.length < 2) {
            return false;
        }

        String last = split[split.length - 1];
        String first = split[0];
        if (last.equals(bracket1[0]) || last.equals(bracket2[0]) || last.equals(bracket3[0])) {
            return false;
        }

        if (first.equals(bracket1[1]) || first.equals(bracket2[1]) || first.equals(bracket3[1])) {
            return false;
        }

        LinkedList<String> link = new LinkedList<>();
        for (String in : split) {
            link.add(in);
        }

        int index = 0;
        String currentLeft;
        String currentRight;
        while (!link.isEmpty() && index < link.size()-1) {
            currentLeft = link.get(index);
            currentRight = link.get(index+1);
            if (currentLeft.equals(bracket1[0]) && currentRight.equals(bracket1[1])) {
                link.remove(index);
                link.remove(index);
                if(index > 0) {
                    index--;
                }
                continue;
            }

            if (currentLeft.equals(bracket2[0]) && currentRight.equals(bracket2[1])) {
                link.remove(index);
                link.remove(index);
                if(index > 0) {
                    index--;
                }
                continue;
            }

            if (currentLeft.equals(bracket3[0]) && currentRight.equals(bracket3[1])) {
                link.remove(index);
                link.remove(index);
                if(index > 0) {
                    index--;
                }
                continue;
            }

            index++;
        }

        return link.isEmpty();
    }

    /**
     * 線上神解
     */
    public boolean isValid3(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
