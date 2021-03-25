/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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


 // https://blog.csdn.net/qq_32534441/article/details/91872381
 /**
  * 	/*
	 * 206. 反转链表 反转一个单链表。
	 * 
	 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
	 *
	 public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		ListNode new_head = reverseList(next);
		next.next = head;
		head.next = null;
		return new_head;
	}

    	/**
	 * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
	 *
	public static Node reverse2(Node head) {
		if (head == null)
			return head;
		Node pre = head;// 上一结点
		Node cur = head.getNext();// 当前结点
		Node tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
		while (cur != null) {// 当前结点为null，说明位于尾结点
			tmp = cur.getNext();
			cur.setNext(pre);// 反转指针域的指向
 
			// 指针往下移动
			pre = cur;
			cur = tmp;
		}
		// 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
		head.setNext(null);
		
		return pre;
	}
}

 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int curIndex = 1;
        ListNode curNode = head;
        ListNode leftPreNode = null;//反转列表之前的节点
        ListNode pre = null;//反转结束后，最后一个节点，也就是被反转列表的新头节点
        while(curNode != null){
            if(curIndex == left){//开始反转
                ListNode rNode = curNode;//保存状态


                pre = rNode;//上一节点
                ListNode cur = rNode.next;//当前节点
                ListNode tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
                while(cur != null && curIndex < right){// 当前结点为null，且最后一个需反转的节点已处理说明位于尾结点
                    tmp = cur.next;
                    cur.next = pre;// 反转指针域的指向

                    // 指针往下移动
                    pre = cur;
                    cur = tmp;
                    curIndex++;
                }

                //重新衔接
                if(leftPreNode != null)
                    leftPreNode.next = pre;//如果开始反转的节点的前一节点不为空， 
                                           //则将next设置为：反转结束后，最后一个节点，也就是被反转列表的新头节点
                rNode.next = cur;//让开始反转的节点的next设置为cur（）
                break;
            }
            leftPreNode = curNode;
            curNode = curNode.next;
            curIndex++;//向后遍历
        }
        if(left == 1){//考虑第一个节点也被反转的情况， 此时反转结束后，最后一个节点即为整个列表的头节点。
            return pre;
        }
        return head;

    }
}


// 2 头插法
// https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
// @lc code=end

