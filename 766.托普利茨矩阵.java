/*
 * @lc app=leetcode.cn id=766 lang=java
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (var i = 0; i < matrix.length - 1; i++) {
            for (var j = 0; j < matrix[0].length - 1; j++) {
                if(matrix[i][j] != matrix[i + 1][j + 1]){
                    return false;
                }          
            }     
        }
        return true;
    }
}
// @lc code=end

