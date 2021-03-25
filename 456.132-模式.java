import java.util.Deque;
import java.util.LinkedList;
/*
 * @lc app=leetcode.cn id=456 lang=java
 *
 * [456] 132模式
 */

// @lc code=start
// 当我们遍历到一个位置 ii 需要寻找数组中左边或者右边的所有数字和 nums[i]nums[i] 的大小关系的题目，可以考虑一下单调栈。
class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if(len < 3){
            return false;
        }
        //存储k值
        //栈中存放j值
        int k = Integer.MIN_VALUE;
        // 递减栈，栈里元素都是比k大元素 即j 
        // 思路就是 确定一个k(次大值) 之后，就去找比k小的值，若有 返回true
        Deque<Integer> stack = new LinkedList<>();
        for (int i = len - 1; i >= 0; i--) {
            //存储k值
            //栈中存放j值
            //若满足nums[i] < k 即132成立, 返回true
            if(nums[i] < k){
                return true;
            }
            // 找到次大值即可
            while(!stack.isEmpty() && stack.peek() < nums[i]){
                k  = stack.pop();
            }
            stack.push(nums[i]);
            
        }
        return false;
    }
}
/**
 * class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if(len < 3){
            return false;
        }
        int leftMin = nums[0];
        for (int i = 1; i < len - 1; i++) {
            if(leftMin > nums[i]){
                leftMin = nums[i];
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if(leftMin < nums[j] && nums[i] > nums[j]){
                    return true;
                }
                // else{
                //     leftMin = Math.min(leftMin, nums[i]);
                // }
            }
            
        }
        return false;
    }
}
 */


// @lc code=end

