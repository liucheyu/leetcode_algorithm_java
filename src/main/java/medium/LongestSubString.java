package medium;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 找出最常的字串，單個字不可重複
 */
public class LongestSubString {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(  solution.lengthOfLongestSubstring("aab"));

    }

    static class Solution {
        /**
         * 1. 迴圈走訪

         */
        public int lengthOfLongestSubstring(String s) {
            byte[] asciis = s.getBytes();
            List<Byte> collect = new ArrayList<>() ;
            byte crr;
            int max = 0;

            for (int i = 0; i < asciis.length; i++) {
                crr = asciis[i];
               if(!collect.contains(crr)) {
                   collect.add(crr);
               } else {
                   if(collect.size() > max) {
                       max = collect.size();
                   }
                   collect = new ArrayList<>() ;
               }

            }

            if(collect.size() > max) {
                max = collect.size();
            }

            return max;
        }


    }
}


