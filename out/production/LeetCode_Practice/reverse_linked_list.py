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
    def reverseList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        prev = None
        curr = head

        while curr is not None:
            next_node = curr.next # store the next node
            curr.next = prev # reverse the link
            prev = curr # move prev to this node
            curr = next_node # move to the next node

        return prev # prev will be the head of the reversed linked list

if __name__ == "__main__":
    head = ListNode(val=1)
    head.next = ListNode(val=2)
    head.next.next = ListNode(val=3)
    head.next.next.next = ListNode(val=4)
    head.next.next.next.next = ListNode(val=5)

    # Print the original list
    print("Original linked list:")
    head.printListNode()

    sol = Solution()
    res = sol.reverseList(head)

    # Print the reversed list
    print("Reversed linked list:")
    res.printListNode()