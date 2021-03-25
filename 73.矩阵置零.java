/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    row[i] = col[j] = true; 
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {   
            for (int j = 0; j < matrix[0].length; j++) {
                if(row[i] || col[j]){
                    matrix[i][j] = 0; 
                }
            }
        }
    }
}
// @lc code=end

