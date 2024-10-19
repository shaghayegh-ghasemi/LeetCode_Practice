class Solution(object):
    def mergeAlternately(self, word1, word2):
        l_w1, l_w2 = len(word1), len(word2)
        length = l_w1 if l_w1 <= l_w2 else l_w2 # set length equal to shorter word
        res = ''

        for i in range(length): # merge alternately
            res = res + word1[i]
            res = res + word2[i]

        if length < l_w1: # add the rest of the longer word
            res = res + word1[length:]
        elif length < l_w2:
            res = res + word2[length:]

        return res


if __name__ == '__main__':
    word1 = "ab"
    word2 = "pqrs"

    sol = Solution()

    res =sol.mergeAlternately(word1, word2)

    print(res)


# problem description: https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75