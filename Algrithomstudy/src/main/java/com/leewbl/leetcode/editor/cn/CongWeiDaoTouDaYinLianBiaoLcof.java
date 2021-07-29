//English description is not available for the problem. Please switch to Chinese
//. Related Topics 栈 递归 链表 双指针 
// 👍 167 👎 0


package com.leewbl.leetcode.editor.cn;

import listnode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int[] reversePrint(ListNode head) {
            if (head == null) {
                return new int[0];
            }
            List<Integer> res = new ArrayList<>();
            reverseAdd(res, head);
            int[] r = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                r[i] = res.get(i);
            }
            return r;
        }

        private void reverseAdd(List<Integer> res, ListNode head) {
            if (head.next != null) {
                reverseAdd(res, head.next);
            }
            res.add(head.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}