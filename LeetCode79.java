'''Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

 

Constraints:

    m == board.length
    n = board[i].length
    1 <= m, n <= 6
    1 <= word.length <= 15
    board and word consists of only lowercase and uppercase English letters.'''

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Checking for entire grid
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int row, int col, int index){
        if(index == word.length()){
            return true;
        }

        // Out of Bound
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }

        // For unmatched character
        if(board[row][col] != word.charAt(index)){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        // Backtrack DFS for searching
        boolean flag = backtrack(board, word, row+1, col, index+1) ||
                       backtrack(board, word, row-1, col, index+1) ||
                       backtrack(board, word, row, col+1, index+1) ||
                       backtrack(board, word, row, col-1, index+1);
        
        // Restore the Character
        board[row][col] = temp;
        return flag;
    }
}