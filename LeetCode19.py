'''Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1]

 

Constraints:

    The number of nodes in the list is sz.
    1 <= sz <= 30
    0 <= Node.val <= 100
    1 <= n <= sz'''


class Solution(object):
    def removeNthFromEnd(self, head, n):
        '''sz = 0
        curr = head

        while curr:
            sz+=1
            curr = curr.next
        
        
        dummy = ListNode(0)
        tail = dummy
        curr = head
        i=0

        while curr:

            if i == (sz-n):
                curr =curr.next
                i+=1
                continue

            tail.next = ListNode(curr.val)
            curr = curr.next
            tail = tail.next
            i+=1
        return dummy.next'''

        dummy = ListNode(0)
        dummy.next = head

        fast = dummy
        slow = dummy
        
        for i in range(0,n+1):
            fast = fast.next
        
        while fast:
            fast = fast.next
            slow = slow.next
        slow.next = slow.next.next
        return dummy.next