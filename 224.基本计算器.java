import java.util.Stack;
/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 */

// @lc code=start
class Solution {
    //只有+ - 可将括号展开, 在栈中记录当前数字应有的符号
    //默认是+, 遇到括号会将当前sign推入栈中
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int res = 0;
        int sign = 1;
        int i = 0;
        while(i < len){
            if(s.charAt(i) == ' '){
                i++;
            }else if(s.charAt(i) == '+') {
                sign = stack.peek();
                i++;
            }
            else if(s.charAt(i) == '-') {
                sign = -stack.peek();
                i++;
            }
            else if(s.charAt(i) == '(') {
                stack.push(sign);
                i++;
            }
            else if(s.charAt(i) == ')') {
                stack.pop();
                i++;
            }
            else {
                //遇到数字开始计算, 一位一位算
                int num = 0;
                while(i < len && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                res += sign * num;

            }
        }
        return res;

    }
}
// @lc code=end

