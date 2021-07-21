//You are given an array of integers nums, there is a sliding window of size k w
//hich is moving from the very left of the array to the very right. You can only s
//ee the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// Example 3: 
//
// 
//Input: nums = [1,-1], k = 1
//Output: [1,-1]
// 
//
// Example 4: 
//
// 
//Input: nums = [9,11], k = 2
//Output: [11]
// 
//
// Example 5: 
//
// 
//Input: nums = [4,-2], k = 2
//Output: [4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 
// 👍 1080 👎 0


package com.leewbl.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{7, 2, 4}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int length = nums.length;
            int[] res = new int[length - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            int c = 0;
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.addLast(i);
            }
            for (int i = k; i < length; i++) {
                res[c++] = nums[deque.peekFirst()];
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                deque.addLast(i);
            }
            res[c] = nums[deque.peekFirst()];
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}