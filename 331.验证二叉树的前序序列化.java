import java.util.Deque;
import java.util.LinkedList;
/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start
class Solution {
    // 把有效的叶子节点使用 "#" 代替。**比如把 4## 替换成 # 。此时，非叶子节点会变成叶子节点！
    public boolean isValidSerialization(String preorder) {
        String[] array = preorder.split(",");
        Deque<String> stack = new LinkedList<>();
        for (String str : array) {
            stack.push(str);
            while(stack.size()>=3 
                && ((LinkedList<String>) stack).get(0).equals("#")
                && ((LinkedList<String>) stack).get(1).equals("#")
                && !((LinkedList<String>) stack).get(2).equals("#")){
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.push("#");
                }
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

    //第二种解法: 入度出度
    //遍历过程中入度一直小于出度
}
// @lc code=end

