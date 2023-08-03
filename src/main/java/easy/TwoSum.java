package easy;
/***
 * https://leetcode.com/problems/two-sum/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] ints = new TwoSum().twoSum20230208(nums, target);
        Arrays.stream(ints).forEach(System.out::println);

    }

    //陣列取2數相加等於target，回傳索引
    public int[] twoSum20230208(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length - 1);
        int num2;
        for (int i = 0; i < nums.length; i++) {
            num2 = target - nums[i];

            if (map.containsKey(num2)) {
                return new int[]{i, map.get(num2)};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    //暴力解
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = 0; j <= nums.length - 1; j++) {
                if (i == j) {
                    continue;
                }

                if (nums[i] + nums[j] == target) {
                    result = new int[]{i, j};
                }
            }
        }

        return result;

        //或官方
        /**
         *   for (int i = 0; i < nums.length; i++) {
         *             for (int j = i + 1; j < nums.length; j++) {
         *                 if (nums[j] == target - nums[i]) {
         *                     return new int[] { i, j };
         *                 }
         *             }
         *         }
         *         // In case there is no solution, we'll just return null
         *         return null;
         */
    }

    //佳解
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> valueAndIndex = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            valueAndIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int minuend = target - nums[i];
            if (valueAndIndex.containsKey(minuend) && valueAndIndex.get(minuend) != i) {
                return new int[]{valueAndIndex.get(minuend), i};
            }
        }

        return null;
    }

    //更佳解
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }

}
