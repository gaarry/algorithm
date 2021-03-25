import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    List<List<String>> list = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<>();
    boolean[][] dy;
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        dy = new boolean[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dy[i] , true);
        }

        for (int i = n - 1; i >= 0 ; i--) {
            for (var j = i + 1; j < n; j++) {
                dy[i][j] = (s.charAt(i) == s.charAt(j)) && 
                    dy[i + 1][j - 1]; //回文串状态转移方程
            }
        }
        dfs(s, 0);
        return list;

    }
    public void dfs(String s, int i) {
        if(i == n){// 达到叶子结点
            list.add(new ArrayList<String>(ans)); //深度拷贝
            return;
        }

        for (int j = i; j < n; j++) {
            if(dy[i][j]){
                ans.add(s.substring(i, j+1));
                dfs(s, j + 1);//(i~j,j+1~n)
                ans.remove(ans.size() - 1);
            }
        }
        
    }
}
// @lc code=end

