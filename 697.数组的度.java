import java.util.HashMap;
import java.util.Map;
/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        //定义一个Map，Key为数组中的值，Value为一个数组，
        //数组的第一个元素为Key出现的次数，第二个元素为Key第一次出现的位置，
        //第三个元素为Key最后一次出现的位置。
        Map<Integer,int[]> map = new HashMap<>();
        int n = nums.length;
        //遍历数组，将每一个元素出现的次数、第一次出现的位置、最后一次出现的位置记录下来
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else{
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        int maxNum = 0;
        int minLen = 0;
        for(Map.Entry<Integer, int[]> entry : map.entrySet()){
            int[] value = entry.getValue();
            if(value[0] > maxNum){
                maxNum = value[0];
                minLen = value[2] - value[1] + 1;
            }else if(value[0] == maxNum){
                if(value[2] - value[1] + 1 < minLen){
                    minLen = value[2] - value[1] + 1;
                }
            }
        }
        return minLen;
    }
}
// @lc code=end

