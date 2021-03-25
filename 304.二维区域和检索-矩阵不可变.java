/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start


class NumMatrix {
    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        if(matrix.length > 0){
            preSum = new int[matrix.length +1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + matrix[i][j];
                }
                
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1]
            + preSum[row1][col1];
        return ans;
    }
}
// class NumMatrix {
//     int[][] preSum;

    // public NumMatrix(int[][] matrix) {
    //     if(matrix.length > 0){
    //         preSum = new int[matrix.length][matrix[0].length + 1];
    //         for (int i = 0; i < matrix.length; i++) {
    //             for (int j = 0; j < matrix[0].length; j++) {
    //                 preSum[i][j + 1] = preSum[i][j] + matrix[i][j];
                    
    //             }
    //         }
    //     }
    // }
    
//     public int sumRegion(int row1, int col1, int row2, int col2) {
//         int ans = 0;
//         for (int i = row1; i <= row2; i++) {
//             ans += preSum[i][col2 + 1] -  preSum[i][col1];
            
//         }
//         return ans;
//     }
// }
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

