class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # Two pointer approach: i tracks position for next unique element
        i: int = 0  # slow pointer - points to last unique element position
        n: int = len(nums)

        # j is fast pointer - explores the array
        for j in range(n):
            # Found a new unique element (different from last unique at i)
            if nums[i] != nums[j]:
                i += 1              # move to next position for unique element
                nums[i] = nums[j]   # place the new unique element
        
        # i+1 gives count of unique elements (i is 0-indexed)
        return i + 1
