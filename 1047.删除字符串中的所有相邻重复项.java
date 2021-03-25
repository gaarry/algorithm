/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String S) {

        char[] chayArray = S.toCharArray();
        int top = -1;
        for (int i = 0; i < chayArray.length; i++) {
            if(top == -1 || chayArray[i] != chayArray[top]){
                chayArray[++top] = chayArray[i];
            }
            else{
                top--;
            }
            
        }
        return String.valueOf(chayArray, 0, top + 1);

    }
}
// class Solution {
//     public String removeDuplicates(String S) {
//         Stack<Character> stack = new Stack<>();
//         StringBuffer sb = new StringBuffer();
//         char[] chayArray = S.toCharArray();
//         for (char ch : chayArray) {
//             if(!stack.isEmpty() && ch == stack.peek()){
//                 stack.pop();
//             }else{
//                 stack.push(ch);
//             }
//         }
//         while(!stack.isEmpty()){
//             sb.append(stack.pop());
//         }
//         return sb.reverse().toString();

//     }
// }
// @lc code=end

