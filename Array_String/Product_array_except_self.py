class Solution(object):
    def productExceptSelf(self, nums):
        n = len(nums)
        res = [1]*n

        # first iterate from left to right and multiply elements and save the left product results except self in the res array
        left_product = 1
        for i in range(n):
            res[i] = left_product # save left product in res
            left_product *= nums[i] # update the left product

        # next to complete the multiplication, iterate from right to left
        right_product = 1
        for i in range(n-1, -1, -1):
            res[i] *= right_product # multiply the right product to the previous left product
            right_product *= nums[i] # update the right product

        return res    

if __name__ == '__main__':
    # nums = [1,2,3,4]
    nums = [-1,1,0,-3,3]

    sol = Solution()

    res = sol.productExceptSelf(nums)

    print(res)

# project description: https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75