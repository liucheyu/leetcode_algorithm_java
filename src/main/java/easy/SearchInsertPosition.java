package easy;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 *
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        int result = new SearchInsertPosition().searchInsert2(nums, target);
        System.out.println(result);
    }

        public int searchInsert(int[] nums, int target) {
            int result = 0;
            for(int i=0;i<nums.length;i++) {
                if(target<= nums[i]) {
                    result = i;
                    break;
                }

                if(i == nums.length-1) {
                    result = i+1;
                    break;
                }

            }

            return result;

        }

    public int searchInsert2(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        int mid;
        while (first <= last) {
            mid = (first+last)/2;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] > target) {
                last = mid-1;
                continue;
            }

            if(nums[mid] < target) {
                first = mid+1;
                continue;
            }

        }

        return first;

    }
}
/**
 * 35. Search Insert Position
 * Easy
 *
 * 9499
 *
 * 462
 *
 * Add to List
 *
 * Share
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
