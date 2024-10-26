class Solution(object):
    def removeStars(self, s):
        if not s: # handle special case
            return ''
        
        stack = []

        for char in s:
            if char != '*': # add any char except * to the stack
                stack.append(char)
            elif char == '*' and len(stack) != 0: # if '*' is found, the last char should be removed, the stack shouldn't be empty!
                stack.pop()

        return ''.join(stack)

if __name__ == "__main__":
    s = "leet**cod*e"
    # s = "erase*****"
    # s = '*'

    sol = Solution()

    res = sol.removeStars(s)

    print(res) # output should be "lecoe"

# project description: https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75