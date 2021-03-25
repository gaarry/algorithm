import java.util.HashMap;
import java.util.Map;
/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有K个重复字符的最长子串
 */

// @lc code=start
class Solution {
    // 递归：如果一个字符 c 在 ss 中出现的次数少于 k 次，
    // 那么 s 中所有的包含 c 的子字符串都不能满足题意。
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if(len < k){
            return 0;
        }
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (var i = 0; i < len; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : map.keySet()) {
            if(map.get(c) < k){
                for (String s1 : s.split(String.valueOf(c))) {
                    ans = Math.max(ans, longestSubstring(s1, k));
                }
                return ans;
            }
        }
        return s.length();
    }
}
// @lc code=end

