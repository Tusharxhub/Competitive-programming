//!  Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]] such that  i != j, i != k, j != k and nums[i] + nums[j] + nums[k] == 0.
import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums); // sort the array to handle duplicates easily

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // need bigger sum
                } else {
                    right--; // need smaller sum
                }
            }
        }
        return result;
    }

    // Simple demo runner. You can modify the array or pass numbers via command line args.
    public static void main(String[] args) {
        int[] nums;
        if (args.length > 0) {
            nums = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                nums[i] = Integer.parseInt(args[i]);
            }
        } else {
            // default sample
            nums = new int[]{-1, 0, 1, 2, -1, -4};
        }

        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> triplet : res) {
            System.out.println(triplet);
        }
    }
}
