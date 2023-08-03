package easy;

/**
 * https://leetcode.com/problems/plus-one/
 */

public class PlusOne {
    public static void main(String[] args) {
        int[] nums = new int[]{9};
        int[] res = new PlusOne().plusOne(nums);
        for(var e : res) {
            System.out.print(e + ",");
        }

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
     * Memory Usage: 40.7 MB, less than 91.30% of Java online submissions for Plus One.
     */
    public int[] plusOne(int[] digits) {
        //從最後一個數+1
        //減10看是否大於0
        //大於0就進位
        int current = 0;
        int up = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            current = digits[i];
            if (i == digits.length - 1) {
                current += 1;
            }

            current += up;

            if (current - 10 >= 0) {
                digits[i] = 0;
                up = 1;
            } else {
                digits[i] = current;
                up = 0;
                break;
            }
        }

        if(up == 0) {
            return digits;
        }

        int[] digits2 = new int[digits.length+1];
        digits2[0] = up;
        for(int i=0;i<digits.length;i++){
            digits2[i+1] = digits[i];
        }

        return digits2;
    }

    /**
     * 網路解
     */
    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        int i = n - 1;
        for (; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (i >= 0) return digits;
        int[] res = new int[n + 1];
        res[0] = 1;
        for (i = 1; i < n + 1; i++) res[i] = digits[i - 1];
        return res;
    }

    /**
     * 網路解2
     */
    public int[] plusOne3(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
