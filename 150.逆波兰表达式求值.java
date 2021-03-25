/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        int[] res = new int[tokens.length];
        int index = -1;
        for (String str : tokens) {
            if(str.equals("+")){
                res[--index] += res[index + 1];
            }else if(str.equals("-")){
                res[--index] -= res[index + 1];
            }else if(str.equals("*")){
                res[--index] *= res[index + 1];
            }else if(str.equals("/")){
                res[--index] /= res[index + 1];
            }else {
                res[++index] = Integer.parseInt(str);
            }

        }
        return res[0];
    }
}
/**
 * class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int tmp = 0;
        for (String str : tokens) {
            if(str.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(str.equals("-")){
                tmp = stack.pop();
                stack.push(stack.pop() - tmp);
            }else if(str.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(str.equals("/")){
                tmp = stack.pop();
                stack.push(stack.pop() / tmp);
            }else {
                stack.push(Integer.parseInt(str));
            }

        }
        return stack.pop();
    }
}
 * */ 
// @lc code=end

