//English description is not available for the problem. Please switch to Chinese
//. Related Topics 栈 设计 
// 👍 161 👎 0


package com.leewbl.leetcode.editor.cn;

import java.util.LinkedList;

public class BaoHanMinhanShuDeZhanLcof {
    public static void main(String[] args) {
        MinStack stack = new BaoHanMinhanShuDeZhanLcof().new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.min();
        stack.pop();
        stack.top();
        stack.min();
        System.out.println(stack);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        LinkedList<Integer> stackA = new LinkedList<>();
        LinkedList<Integer> queueB = new LinkedList<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            stackA.addLast(x);
            if (queueB.isEmpty()) {
                queueB.addLast(x);
            } else if (queueB.peekLast() >= x) {
                queueB.addLast(x);
            }
        }

        public void pop() {
            if (!stackA.isEmpty()) {
                int remove = stackA.removeLast();
                if (!queueB.isEmpty() && remove == queueB.peekLast()) {
                    queueB.removeLast();
                }
            }
        }

        public int top() {
            if (stackA.isEmpty()) {
                return 0;
            }
            return stackA.peekLast();
        }

        public int min() {
            if (queueB.isEmpty()) {
                return 0;
            }
            return queueB.peekLast();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}