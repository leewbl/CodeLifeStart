//Suppose you are given the following code: 
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// The same instance of FooBar will be passed to two different threads: 
//
// 
// thread A will call foo(), while 
// thread B will call bar(). 
// 
//
// Modify the given program to output "foobar" n times. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: "foobar"
//Explanation: There are two threads being fired asynchronously. One of them cal
//ls foo(), while the other calls bar().
//"foobar" is being output 1 time.
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: "foobarfoobar"
//Explanation: "foobar" is being output 2 times.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics 多线程 
// 👍 121 👎 0


package com.leewbl.leetcode.editor.cn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class PrintFoobarAlternately {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FooBar {
        private int n;
        CountDownLatch waitFoo = new CountDownLatch(1);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                try {
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                printFoo.run();
                waitFoo.countDown();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                try {
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                waitFoo.await();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                waitFoo = new CountDownLatch(1);

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}