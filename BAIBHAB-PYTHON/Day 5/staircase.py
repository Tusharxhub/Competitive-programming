class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        
        one_step_before = 2
        two_steps_before = 1
        
        for i in range(3, n + 1):
            current_ways = one_step_before + two_steps_before
            two_steps_before = one_step_before
            one_step_before = current_ways
            
        return one_step_before