'''Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

 

Constraints:

    0 <= word1.length, word2.length <= 500
    word1 and word2 consist of lowercase English letters.'''

class Solution {
    public int minDistance(String word1, String word2) {

       Integer[][] dp = new Integer[word1.length()][word2.length()];
       return editDistance(word1, word2, word1.length()-1, word2.length()-1, dp);
       }

    public int editDistance(String w1, String w2, int m, int n, Integer[][] dp){

        if (m < 0){
            return n+1;
        }

        if (n < 0){
            return m+1;
        }

        if (dp[m][n] != null){
            return dp[m][n];
        }

        if (w1.charAt(m) == w2.charAt(n)){
            return dp[m][n] = editDistance(w1, w2, m-1, n-1, dp);
        }

        return dp[m][n] = 1 + Math.min(editDistance(w1, w2, m-1, n, dp), Math.min(editDistance(w1, w2, m, n-1, dp) , editDistance(w1, w2, m-1, n-1, dp)));
    }
}