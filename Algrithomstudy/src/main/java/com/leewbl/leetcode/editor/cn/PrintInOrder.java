//Suppose we have a class: 
//
// 
//public class Foo {
//  public void first() { print("first"); }
//  public void second() { print("second"); }
//  public void third() { print("third"); }
//}
// 
//
// The same instance of Foo will be passed to three different threads. Thread A 
//will call first(), thread B will call second(), and thread C will call third(). 
//Design a mechanism and modify the program to ensure that second() is executed af
//ter first(), and third() is executed after second(). 
//
// Note: 
//
// We do not know how the threads will be scheduled in the operating system, eve
//n though the numbers in the input seem to imply the ordering. The input format y
//ou see is mainly to ensure our tests' comprehensiveness. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: "firstsecondthird"
//Explanation: There are three threads being fired asynchronously. The input [1,
//2,3] means thread A calls first(), thread B calls second(), and thread C calls t
//hird(). "firstsecondthird" is the correct output.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3,2]
//Output: "firstsecondthird"
//Explanation: The input [1,3,2] means thread A calls first(), thread B calls th
//ird(), and thread C calls second(). "firstsecondthird" is the correct output.
// 
//
// 
// Constraints: 
//
// 
// nums is a permutation of [1, 2, 3]. 
// 
// Related Topics 多线程 
// 👍 307 👎 0


package com.leewbl.leetcode.editor.cn;

import java.util.concurrent.CountDownLatch;

public class PrintInOrder {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Foo {
        CountDownLatch waitFirst = new CountDownLatch(1);
        CountDownLatch waitSecond = new CountDownLatch(1);
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            waitFirst.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            waitFirst.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            waitSecond.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            waitSecond.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}