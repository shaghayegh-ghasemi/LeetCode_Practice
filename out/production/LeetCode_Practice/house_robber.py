class Solution(object):
    def rob(self, nums):
        n = len(nums)

        # handle special cases when nums is empty or there exists only one house
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
        
        dp = [0]*n # dp keeps track of the max money that can be robbed until the current house
        dp[0] = nums[0] # max money for first house is equal to the money from the first house
        dp[1] = max(nums[0], nums[1]) # max money in the second house is the max between first and second house since only one of them can be robbed

        for i in range(2, n):
            dp[i] = max(dp[i-1], nums[i] + dp[i-2]) # maxax money at i is the max between robbing the current house plus money from i-2, or robbing house i-1

        return dp[-1]



if __name__ == '__main__':
    nums = [2,7,9,3,1]

    sol = Solution()

    res = sol.rob(nums)

    print(res)

# problem description: https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=leetcode-75