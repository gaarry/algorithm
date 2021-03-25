/*
 * @lc app=leetcode.cn id=1052 lang=java
 *
 * [1052] 爱生气的书店老板
 */

// @lc code=start
class Solution {
    //先把确定满意的顾客加起来。然后滑动窗口计算可以额外增加的最大满意顾客数。
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int res = 0, extra = 0, tmp = 0;
        int left = 0, right = 0;
        while(right < len){
            res += (1 - grumpy[right]) * customers[right];
            tmp += grumpy[right] * customers[right++];
            extra = Math.max(extra, tmp);
            if(right - left == X){
                tmp -= grumpy[left] * customers[left++];
            }
        }
        return res + extra;
    }
}
// @lc code=end

