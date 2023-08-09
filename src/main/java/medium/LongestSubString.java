package medium;

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

            int left = 0;
            byte current;
            int maxLenth = 0;

            Set<Byte> set = new HashSet<>();

            for (int right = 0; right < asciis.length; right++) {
                current = asciis[right];
                if(!set.contains(current)) {
                    set.add(current);
                    maxLenth = Math.max(maxLenth, right - left + 1);
                } else {
                    while (set.contains(current)) {
                        set.remove(asciis[left]);
                        left++;
                    }
                    set.add(current);
                }

            }

            return maxLenth;
        }


    }
}


