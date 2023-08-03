package easy;
/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4,5};
        int k = new RemoveDuplicates().removeDuplicates(nums);
        Arrays.asList(nums).forEach(System.out::print);
        System.out.println();
        System.out.println(k);
    }

    /**
     * Runtime: 2 ms, faster than 56.64% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 47.1 MB, less than 83.19% of Java online submissions for Remove Duplicates from Sorted Array.
     */
    public int removeDuplicates(Integer[] nums) {
        int numIndex = 0;
        int stopIndex = 0;
        int checkIndex = 1;

        while (checkIndex < nums.length) {
            if(nums[numIndex] !=  nums[checkIndex]) {
                stopIndex++;
                nums[stopIndex] = nums[checkIndex];
            }

            numIndex = checkIndex;
            checkIndex++;
        }

        nums[stopIndex] = nums[numIndex];

        return stopIndex + 1;
    }

    /**
     * 網路神解
     */
    public int removeDuplicate2(int[] nums) {
        int i = 1;
        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;
    }
}
