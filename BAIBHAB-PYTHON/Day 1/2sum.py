from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int] | None:
        n: int = len(nums)

        for i in range(0, n-1):
            for j in range(i+1, n):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return None


# main function nije lekh bara, leetcode e nei