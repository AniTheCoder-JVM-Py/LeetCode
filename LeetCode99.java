/*You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

 

Example 1:

Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:

Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.

 

Constraints:

    The number of nodes in the tree is in the range [2, 1000].
    -231 <= Node.val <= 231 - 1*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Morris Inorder Traversal Algorithm is used
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;

        TreeNode curr = root;

        while(curr != null){

            if(curr.left == null){
                // BST Violation
                if(prev != null && prev.val > curr.val){
                    if(first == null)
                        first = prev;
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            }

            else{
                TreeNode pred = curr.left;

                // Searching the righmost element of left subtree
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }

                if(pred.right == null){
                        pred.right = curr;
                        curr = curr.left;
                }
                else{
                        pred.right = null;
                        
                        // BST Violation
                        if(prev != null && prev.val > curr.val){
                            if(first == null)
                                first = prev;
                            second = curr;
                        }
                        prev = curr;
                        curr = curr.right;
                }
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}