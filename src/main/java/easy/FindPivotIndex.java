package easy;

public class FindPivotIndex {

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        //int[] nums = {-1,-1,-1,-1,-1,-1};
        //int[] nums = {-1,-1,-1,-1,-1,0};
        //int[] nums = {2,1,-1};
        //int[] nums = {-1,-1,-1,-1,-1,-1};
        int result = new Solution().pivotIndex(nums);

        System.out.println(result);
    }

    /**
     * 更佳解法
     */
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

    /**
     * Input: nums = [1,7,3,6,5,6]
     * Output: 3
     * Explanation:
     * The pivot index is 3.
     * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
     * Right sum = nums[4] + nums[5] = 5 + 6 = 11
     * <p>
     * 1 <= nums.length <= 104
     * -1000 <= nums[i] <= 1000
     */
    static class Solution {
        public int pivotIndex(int[] nums) {
            if(nums.length == 2 && nums[1] == 0) {
                return 0;
            }

            if(nums.length == 0 && nums[0] == 0) {
                return 0;
            }


            if (nums.length < 3) {
                return -1;
            }

            int rightIndex = nums.length - 1;
            int leftIndex = 0;

            int leftSum = nums[leftIndex];
            int rightSum = nums[rightIndex];

            while (true) {
                int diff = rightIndex - leftIndex;

                if(diff == 2) {
                    break;
                }

                rightIndex--;
                rightSum += nums[rightIndex];
            }

            int middleIndex = leftIndex +1;

            if(rightSum + nums[middleIndex] ==0) {
                return 0;
            }

            int result = -1;

            while (true) {
                if(leftSum == rightSum) {
                    result = middleIndex;
                    break;
                }

                if(leftIndex == -1 || rightIndex == nums.length) {
                    break;
                }

                middleIndex = rightIndex;
                rightIndex++;
                rightSum-=nums[middleIndex];

                leftIndex++;
                leftSum+=nums[leftIndex];
            }

            return result;
        }

    }
}

