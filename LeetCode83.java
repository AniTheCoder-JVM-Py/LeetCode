/*Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:

Input: head = [1,1,2]
Output: [1,2]

Example 2:

Input: head = [1,1,2,3,3]
Output: [1,2,3]

 

Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        /*ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                prev = prev.next;
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                prev.next = curr.next;
            }
            else{
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;*/

        ListNode dummy = head;
        while(dummy != null && dummy.next != null){
            if(dummy.val == dummy.next.val){
                dummy.next = dummy.next.next;
            }
            else{
                dummy = dummy.next;
            }
        }
        return head;
    }
}