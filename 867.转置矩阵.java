/*
 * @lc app=leetcode.cn id=867 lang=java
 *
 * [867] 转置矩阵
 */

// @lc code=start
class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] array = new int[matrix[0].length][matrix.length];
        for (var j = 0; j < matrix.length; j++) {
            for (var i = 0; i < matrix[0].length; i++) {
                array[i][j] = matrix[j][i];
                
            }
        }
        return array;
    }
}
// @lc code=end

