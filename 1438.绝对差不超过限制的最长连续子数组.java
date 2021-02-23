import java.util.TreeMap;
/*
 * @lc app=leetcode.cn id=1438 lang=java
 *
 * [1438] 绝对差不超过限制的最长连续子数组
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int len = nums.length;
        int left = 0;
        int right = 0;
        int res = 0;
        while(right < len){
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            while(treeMap.lastKey() - treeMap.firstKey() > limit){
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                if(treeMap.get(nums[left]) == 0){
                    treeMap.remove(nums[left]);
                }
                left++;
            }
            res = Math.max((right - left + 1), res);
            right++;
        }
        return res;
        
    }
}
// @lc code=end

