import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> list = new ArrayDeque<>();
    //List<Integer> list = new ArrayList<>();
    int n;
    boolean used[];
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        if(n == 0) return null;
        used = new boolean[n];
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int depth) {
        if(depth == n){
            ans.add(new ArrayList<>(list));
            return ;
        }
        for (int i = 0; i < n; i++) {
            if(!used[i]){
                used[i] = true;
                list.addLast(nums[i]);
                //list.add(nums[i]);
                dfs(nums, depth + 1);
                used[i] = false;
                //list.remove(nums[i]); //remove int会有问题， 用堆栈比较好
                list.removeLast();
            }
        }
    }
}
// @lc code=end

