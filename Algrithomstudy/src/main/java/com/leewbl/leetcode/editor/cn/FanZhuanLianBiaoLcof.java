//English description is not available for the problem. Please switch to Chinese
//. Related Topics 递归 链表 
// 👍 269 👎 0


package com.leewbl.leetcode.editor.cn;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;
import listnode.ListNode;

public class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode tmp;
            while (head!= null) {
                tmp = head.next;
                head.next = pre;
                pre = head;
                head = tmp;
            }

            return pre;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}