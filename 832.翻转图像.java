/*
 * @lc app=leetcode.cn id=832 lang=java
 *
 * [832] 翻转图像
 */

// @lc code=start
class Solution {
    static int index = 0;
    public int[][] flipAndInvertImage(int[][] A) {
        //用双指针 每次首尾交换并且反转
        int arrysLength  = A.length;
        int arryLength  = A[0].length;
        for (int i = 0; i < arrysLength; i++) {
            int l = 0, r = arryLength - 1;
            while(l <= r){
                // 1.首尾交换
                int tmp = 1 - A[i][l];
                A[i][l] = 1 - A[i][r];
                A[i][r] = tmp;
                l++;
                r--;
                // 2.总结规律，首尾不同时数值不变，相同时才反转。
            }
        }  
        index ++;
        return A;    
    }
}
// @lc code=end

