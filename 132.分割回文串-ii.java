import java.util.Arrays;
/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

// @lc code=start
class Solution {
    boolean[][] dy;
    int n;
    public int minCut(String s) {
        n = s.length();
        dy = new boolean[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dy[i], true);
        }

        for (int i = n - 1; i >= 0 ; i--) {
            for (var j = i + 1; j < n; j++) {
                dy[i][j] = (s.charAt(i) == s.charAt(j)) && 
                    dy[i + 1][j - 1]; //回文串状态转移方程
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if(dy[0][i]){
                f[i] = 0;
            }else{
                for (int j = 0; j < i; j++) {
                    if(dy[j + 1][i]){
                        f[i] = Math.min(f[i], f[j] + 1);//状态转移方程， 若(j + 1 ～ i)为回文串，
                        // 则最短切割数为 f[i], f[j] + 1（在j切）的最小值
                    }  
                }
            }
        }
        return f[n - 1];
    }

}

// @lc code=end

