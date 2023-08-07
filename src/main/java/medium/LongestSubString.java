package medium;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 找出最常的字串，單個字不可重複
 */
public class LongestSubString {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("au"));

    }

    static class Solution {
        /**
         * 1. 迴圈走訪
         */
        public int lengthOfLongestSubstring(String s) {
            byte[] asciis = s.getBytes();
            if (asciis.length == 0) {
                return 0;
            }

            if (asciis.length == 1) {
                return 1;
            }

            int left = 0;
            int right = 1;
            byte current;
            int maxLenth = 0;
            int crrLength = 0;
            int removeEnd;
            //Set<Byte> set = new HashSet<>();
            Map<Byte, Integer> map = new HashMap<>();
            boolean availible;
            for (int i = 0; i < asciis.length; i++) {
                current = asciis[i];
                //availible = set.add(current);
                availible = !map.containsKey(current);
                right = i;
                crrLength = right - left + 1;
                if (!availible) {
                    if (crrLength > maxLenth) {
                        maxLenth = crrLength;
                    }

                    removeEnd = map.get(current);
                    for (int j = left; j <= removeEnd; j++) {
                        map.remove(asciis[j]);
                    }

                    left = removeEnd + 1;
                }
                map.put(current, i);


            }

            if (crrLength > maxLenth) {
                maxLenth = crrLength;
            }


            return maxLenth;
        }


    }
}


