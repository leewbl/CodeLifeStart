//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics 递归 链表 数学 
// 👍 6429 👎 0


package com.leewbl.leetcode.editor.cn;
public class AddTwoNumbers{
  public static void main(String[] args) {
       Solution solution = new AddTwoNumbers().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode root = tmp;
        int num, append = 0;
        while (l1 != null && l2 != null) {
            num = (l1.val + l2.val + append) % 10;
            append = (l1.val + l2.val + append - num) / 10;
            tmp.val = num;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 == null) {
                if (append == 0) {
                    tmp.next = null;
                    break;
                } else {
                    tmp.next = new ListNode(append);
                }
            } else {
                tmp.next = new ListNode(0);
            }
            tmp = tmp.next;
        }
        while (l1 != null) {
            num = (l1.val + append) % 10;
            append = (l1.val + append - num) / 10;
            tmp.val = num;
            l1 = l1.next;
            if (l1 == null) {
                if (append == 0) {
                    tmp.next = null;
                    break;
                } else {
                    tmp.next = new ListNode(append);
                }
            } else {
                tmp.next = new ListNode(0);
            }
            tmp = tmp.next;
        }
        while (l2 != null) {
            num = (l2.val + append) % 10;
            append = (l2.val + append - num) / 10;
            tmp.val = num;
            l2 = l2.next;
            if (l2 == null) {
                if (append == 0) {
                    tmp.next = null;
                    break;
                } else {
                    tmp.next = new ListNode(append);
                }
            } else {
                tmp.next = new ListNode(0);
            }
            tmp = tmp.next;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}