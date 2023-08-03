package easy;
/**
 * https://leetcode.com/problems/longest-common-prefix/
 */

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strs = {"漢堡好吃", "漢堡不好吃", "漢堡難吃", "漢堡堡"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix20230215(strs));
    }

    public String longestCommonPrefix20230215(String[] strs) {
        String strIndex0 = strs[0];
        if (strs.length == 1) {
            return strIndex0;
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strIndex0.charAt(i) != strs[j].charAt(i)) {
                    return strIndex0.substring(0, i);
                }
            }
        }
        return strIndex0;
    }

    /**
     * Runtime: 1 ms, faster than 89.44% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 40 MB, less than 98.69% of Java online submissions for Longest Common Prefix.param strs
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String str = strs[0];
        String currentStr;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for (int j = 0; j < str.length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                flag = false;
                currentStr = strs[i];
                if (j > currentStr.length() - 1) {
                    break;
                }

                flag = currentStr.charAt(j) == str.charAt(j);
                if (!flag) {
                    break;
                }
            }

            if (flag) {
                sb.append(str.charAt(j));
            } else {
                break;
            }
        }

        return sb.toString();
    }


    /**
     * 網上用sort的作法
     * 但不太懂，這沒有處理中間有不同
     * 這只能用在英文的比對(合乎題目沒錯...)，Arrays.sort比對字串會用abcdefg...為順序比對
     * ex: ab會排在ac前面
     * 但很明顯這內部一定也有跑迴圈......
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while (c < first.length()) {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);
    }

    /**
     * 網上用java String indexOf的作法，indexOf裡面有for+while兩層，不確定indexOf跑幾次迴圈
     * 但一定慢
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }

}
