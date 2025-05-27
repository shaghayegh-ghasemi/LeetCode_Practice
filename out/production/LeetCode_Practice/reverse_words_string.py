class Solution(object):
    def reverseWords(self, s):
        words = s.split()
        words.reverse()

        res = words[0]

        for i in range(1, len(words)):
            res = res + ' ' + words[i]

        return res

if __name__ == '__main__':
    # s = "the sky is blue"
    # s = "  hello world  "
    s = "a good   example"

    sol = Solution()

    res = sol.reverseWords(s)

    print(res)

# problem description: https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75

