import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
    	if (envelopes.length == 0)
    		return 0;

		Arrays.sort(envelopes, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				if (o1[0]==o2[0]) return o2[1]-o1[1];
				else return o1[0]-o2[0];
			}
		});
		//最长严格递增子序列
		int n = envelopes.length;
		int ans = 1;
		int len[] = new int[n];
        Arrays.fill(len, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(envelopes[j][1] < envelopes[i][1]){
					len[i] = Math.max(len[i], len[j] + 1);
				}
				ans = Math.max(len[i], ans);
			}
			
			
		}
		return ans;
    }
}

// @lc code=end

