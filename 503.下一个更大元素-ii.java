import java.util.Arrays;
import java.util.Stack;
/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        for (int i = 0; i < len * 2 - 1; i++) {
            while(!stack.isEmpty() && nums[i % len] > nums[stack.peek()]){
                ans[stack.peek()] = nums[i % len];
                stack.pop(); //将小于当前数全部弹出
            }
            stack.push(i % len); //栈中存储数组下标
        }
        return ans;

    }
}
// @lc code=end

