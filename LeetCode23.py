'''You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []

Example 3:

Input: lists = [[]]
Output: []

 

Constraints:

    k == lists.length
    0 <= k <= 104
    0 <= lists[i].length <= 500
    -104 <= lists[i][j] <= 104
    lists[i] is sorted in ascending order.
    The sum of lists[i].length will not exceed 104.'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):

    def mergeTwoLists(self, list1, list2):
            dummy = ListNode(0)
            curr = dummy

            while list1 and list2:

                if list1.val <= list2.val:
                    curr.next = list1
                    list1 = list1.next
                else:
                    curr.next = list2
                    list2 = list2.next
                curr = curr.next

            if list1:
                curr.next = list1
                
            if list2:
                curr.next = list2
            return dummy.next

    def mergeKLists(self, lists):
        
        if not lists:
            return None
        
        while len(lists) > 1:
            mergedLists = []

            for i in range(0,len(lists),2):
                list1 = lists[i]
                
                if i+1 < len(lists):
                    list2 = lists[i+1]
                else:
                    list2 = None
                
                mergedLists.append(self.mergeTwoLists(list1,list2))
            
            lists = mergedLists
        return lists[0]