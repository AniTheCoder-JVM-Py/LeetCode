/*Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:

Input: matrix = [["0"]]
Output: 0

Example 3:

Input: matrix = [["1"]]
Output: 1

 

Constraints:

    rows == matrix.length
    cols == matrix[i].length
    1 <= rows, cols <= 200
    matrix[i][j] is '0' or '1'.*/

// Using each row as Histogram
// Then using largest rectangle algorithm

class Solution {
    public int maximalRectangle(char[][] matrix) {

        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];
        int maxArea = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }
                else{
                    height[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangle(height));
        }
        return maxArea;
    }

    public int largestRectangle(int[] heights){

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for(int i = 0; i <= n; i++){
            int currHeight = (i==n)?0:heights[i];

            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width;

                if(stack.isEmpty()){
                    width = i;
                }
                else{
                    width = i-stack.peek()-1;
                }
                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}