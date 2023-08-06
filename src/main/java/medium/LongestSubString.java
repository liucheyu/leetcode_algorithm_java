package medium;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 找出最常的字串，單個字不可重複
 */
public class LongestSubString {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(  solution.lengthOfLongestSubstring("abcabcbb"));

    }

    static class Solution {
        /**
         * 1. 迴圈走訪

         */
        public int lengthOfLongestSubstring(String s) {
            byte[] asciis = s.getBytes(Charset.forName("ASCII"));
            byte crr;
            byte next;
            int count = 0;

            for (int i = 0; i+1 < asciis.length; i++) {


            }

        }


    }
}


