/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] A) {
        if(A[0] < A[A.length-1]){
            for (var i = 1; i < A.length; i++) {
                if(A[i] < A[i-1]){
                    return false;
                }
                
            }
        }else if(A[0] > A[A.length-1]){
            for (var i = 1; i < A.length; i++) {
                if(A[i] > A[i-1]){
                    return false;
                }
                
            }
        }else if(A[0] == A[A.length-1]){
            for (var i = 1; i < A.length; i++) {
                if(A[i] != A[i-1]){
                    return false;
                }
                
            }
        }
        return true;

    }
}
// @lc code=end

