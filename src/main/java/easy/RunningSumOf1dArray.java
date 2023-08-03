package easy;

import java.util.Arrays;

/**
 * 1480. Running Sum of 1d Array
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */
public class RunningSumOf1dArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution solution = new Solution();
        int[] result = solution.runningSum(nums);

        String[] sarr = Arrays.stream(result).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.printf("[%s]\n", String.join(",", sarr));
    }

    static class Solution {
        public int[] runningSum(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] = nums[i] + nums[i - 1];
            }

            return nums;
        }
    }
}

