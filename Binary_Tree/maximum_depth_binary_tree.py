# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def maxDepth(self, root):
        if not root: # special case
            return 0
        
        left_subtree_d = self.maxDepth(root.left) # get the depth of left subtree
        right_subtree_d = self.maxDepth(root.right) # get the depth of right subtree

        return max(left_subtree_d, right_subtree_d) + 1 # max depth of binary tree is eqaul to max depth between left and right subtree
    
if __name__ == '__main__':
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)

    sol = Solution()

    depth = sol.maxDepth(root)

    print(depth)

# problem description: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75