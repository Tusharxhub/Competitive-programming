//! Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

//! 0 <= a, b, c, d < n
//! a, b, c, and d are distinct.
//! nums[a] + nums[b] + nums[c] + nums[d] == target
//! You may return the answer in any order.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * Finds all unique quadruplets in the array which gives the sum of target.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return A list of all unique quadruplets that sum up to the target.
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        int n = nums.length;
        // 1. Sort the array
        Arrays.sort(nums);

        // 2. Outer loop for the first number
        for (int i = 0; i < n - 3; i++) {
            // 3. Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 2. Inner loop for the second number
            for (int j = i + 1; j < n - 2; j++) {
                // 3. Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 4. Two-pointers for the remaining two numbers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // Use 'long' to prevent integer overflow
                    long currentSum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (currentSum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Move pointers and skip duplicates for the third number
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicates for the fourth number
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (currentSum < target) {
                        left++;
                    } else { // currentSum > target
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = sol.fourSum(nums, target);
        for (List<Integer> quad : result) {
            System.out.println(quad);
        }
    }
}