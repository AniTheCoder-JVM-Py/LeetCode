/*Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:

Input: n = 3
Output: 5

Example 2:

Input: n = 1
Output: 1

 

Constraints:

    1 <= n <= 19*/

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int nodes = 2; nodes <= n; nodes++){
            for(int root = 1; root <= nodes; root++){
                int left = root - 1;
                int right = nodes - root;

                dp[nodes] = dp[nodes] + dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}