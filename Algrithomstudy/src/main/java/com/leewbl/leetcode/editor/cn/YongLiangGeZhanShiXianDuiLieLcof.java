//English description is not available for the problem. Please switch to Chinese
//. Related Topics 栈 设计 队列 
// 👍 273 👎 0


package com.leewbl.leetcode.editor.cn;

import java.util.Iterator;
import java.util.LinkedList;

public class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        LinkedList<Integer> sa = new LinkedList<>();
        LinkedList<Integer> sb = new LinkedList<>();


        public CQueue() {

        }

        public void appendTail(int value) {
            sa.addLast(value);
        }

        public int deleteHead() {
            if (sb.isEmpty()) {
                if (sa.isEmpty()) {
                    return -1;
                } else {
                    Iterator iterator = sa.iterator();
                    while (iterator.hasNext()) {
                        sb.addLast(sa.removeLast());
                    }
                    return sb.removeLast();
                }
            } else {
                return sb.removeLast();
            }
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}