/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode resHead = new ListNode(-1, head);
        ListNode curNode = resHead;
        ListNode preNode = resHead;
        while(curNode.next != null){
            if(curNode.next.next != null && curNode.next.val == curNode.next.next.val){
                curNode = curNode.next;
                while(curNode.next != null && curNode.val == curNode.next.val){
                    curNode = curNode.next;
                }
                preNode.next = curNode.next;
            }else{
                preNode = curNode.next;
                curNode = curNode.next;
                
            }
        }
        return resHead.next;

    }

}
// @lc code=end

