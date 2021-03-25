/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // ans[i] = ans[i >> 1] + (i & 1); 
            ans[i] = ans[i & (i - 1)] + 1; 
        }
        return ans;

    }
}
// 第一种解法，按位与运算（&）的一个性质是：对于任意整数 x，
//令 x=x&(x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0。
//因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。

// class Solution {
//     public int[] countBits(int num) {
//         int[] ans = new int[num + 1];
//         for (int i = 1; i <= num; i++) {
//             ans[i] = count(i); 
//         }
//         return ans;

//     }

//     public int count(int num){
//         int bits = 0;
//         while(num > 0){
//             num &= (num - 1);
//             bits++;
//         }
//         return bits;
//     }
// }
// @lc code=end

