import java.util.Stack;
/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (s.charAt(i) - '0');
            }
            if(!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1){
                switch(preSign){
                    case '+':
                        stack.push(+num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default :
                        stack.push(stack.pop() / num);
                }
                preSign = ch;
                num = 0;
            }
        }
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;

    }
}
// @lc code=end

