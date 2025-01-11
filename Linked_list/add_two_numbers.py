class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    def printListNode(self): # function to print the linked list
        curr = self
        while curr is not None:
            print(curr.val, end=" -> ")
            curr = curr.next
        print("None")


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        num1 = self.nodeToNumber(l1)
        num2 = self.nodeToNumber(l2)
        return self.numberToNode(num1 + num2)

    # convert a list node to a number - head of the list node is the right most digit
    def nodeToNumber(self, l):
        curr = l
        num = 0
        i = 0
        while curr != None:
            num += (curr.val) * (10)**i
            i += 1
            curr = curr.next
        return num
    
    # convert a number to list node - head of the list node is the right most digit
    def numberToNode(self, num):
        res = ListNode(num%10)
        curr = res
        tmp = num //10
        while tmp != 0:
            curr.next = ListNode(tmp%10)
            curr = curr.next
            tmp = tmp // 10
            
        return res

if __name__ == "__main__":
    l1 = ListNode(val=2)
    l1.next = ListNode(val=4)
    l1.next.next = ListNode(val=3)

    l2 = ListNode(val=5)
    l2.next = ListNode(val=6)
    l2.next.next = ListNode(val=4)

    sol = Solution()
    res = sol.addTwoNumbers(l1, l2)

    print("l1:")
    l1.printListNode()

    print("l2:")
    l2.printListNode()

    print("Result of adding l1 and l2:")
    res.printListNode()

#Problem Description: https://leetcode.com/problems/add-two-numbers/submissions/1504627824/?envType=study-plan-v2&envId=top-interview-150