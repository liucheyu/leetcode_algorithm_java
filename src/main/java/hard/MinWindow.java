package hard;

import javax.management.StringValueExp;
import java.util.*;

public class MinWindow {
    /**
     * 76. Minimum Window Substring
     * Hard

     * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
     *
     * The testcases will be generated such that the answer is unique.
     *
     * A substring is a contiguous sequence of characters within the string.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     * Example 2:
     *
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     * Example 3:
     *
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     */
    public static void main(String[] args) {
        String s = new MinWindow().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }


    /**
     * AxxDxxBxxDxAxCxxBxxxAxBxCxxB
     * 相同字在頭
     * 相同字在中間
     * 相同字在尾
     */

    public String minWindow(String s, String t) {
        String[] insert = s.split("");
        String[] find = t.split("");

        if(find.length > insert.length) {
            return "";
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0;i< insert.length;i++) {
            sb.append(insert[i]);
            if(checkAllContain(find, sb.toString())) {

            }
        }

        return "";
    }

    boolean checkAllContain(String[] find, String check) {
        int count = 0;
        for(int i=0;i< find.length;i++) {
            if(check.contains(find[i])) {
                count++;
            }
        }

        if(count == find.length) {
            return true;
        }

        return false;
    }



}



