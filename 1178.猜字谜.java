import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * @lc app=leetcode.cn id=1178 lang=java
 *
 * [1178] 猜字谜
 */

// @lc code=start
class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        // 获取每个word的二进制数， 并且存入map
        for(String word : words){
            int bit = 0;
            for (int i = 0; i < word.length(); i++) {
                bit |= (1 << (word.charAt(i) - 'a'));
            }
            map.put(bit, map.getOrDefault(bit, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();


        //通过 puzzle 反推 word
        
        // 一个二进制状态数字k的子集
        // 方法就是针对中的二进制为1的位开始进行减法，
        // 判断数字k的二进制子集, 像枚举(2^k-1) ~ 0一样枚举其子集
        //  int sub = k;
        // do {
        //  sub = (sub - 1) & k;
        // } while(sub != k);

        for (String puzzle : puzzles) {
            int tot = 0;
            int bit = 0;
            // puzzle 和 word首字母相同， 所以只需要计算其余六位的二进制子集
            for (int i = 1; i < puzzle.length(); i++) {
                bit |= 1 << (puzzle.charAt(i) - 'a');
            }
            int subset = bit;
            //while(subset != 0){
            do{
                // 加上首位字母。判断子集中是否有word存在
                int s = subset | 1 << (puzzle.charAt(0) - 'a');
                if(map.containsKey(s)){
                    tot += map.get(s);
                }
                // 寻找二进制子集
                subset = (subset - 1) & bit;// 在subset减到 0 时，
            //}
            } while (subset != bit);// 若是判断为subset != 0，会漏掉bit本身的情况,应该为5：{4,1,0,5}
            //0 也是subset的子集，但是再 -1，会变成 -1，-1 二进制表示为 1111 1111，
            //最高位1表示是负数，与mask做与运算，不相同位归零，重新变回mask，循环终止。
            ans.add(tot);
        }

        return ans;
    }

}
// @lc code=end

