package medium;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    /**
     * babad
     * babad
     * bacabad
     * cbbd
     */
    class Solution {
        public String longestPalindrome(String s) {
            /**
             * 1. 檢查start和start起始要檢查的長度（lenght），也就是最後一個index
             * 2. start每次都從0開始，由長度來倒數。每次都要start和剩餘長度檢查是否網內縮會是一樣的
             * 3. 迴圈反轉也行
             */

            for (int length = s.length(); length > 0; length--) {
                for (int start = 0; start <= s.length() - length; start++) {
                    if (check(start, start + length, s)) {
                        return s.substring(start, start + length);
                    }
                }
            }

            return "";

        }

        public boolean check(int i,int j, String s) {
            int left = i;
            int right = j-1;
            while (left < right) {
                if(s.charAt(left) != s.charAt(right)) {
                    return false;
                }
            }

            return true;
        }
    }
}
