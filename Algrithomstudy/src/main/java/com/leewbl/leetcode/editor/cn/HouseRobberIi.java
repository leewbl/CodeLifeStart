//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed. All houses at this place are arranged i
//n a circle. That means the first house is the neighbor of the last one. Meanwhil
//e, adjacent houses have a security system connected, and it will automatically c
//ontact the police if two adjacent houses were broken into on the same night. 
//
// Given an integer array nums representing the amount of money of each house, r
//eturn the maximum amount of money you can rob tonight without alerting the polic
//e. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 
//2), because they are adjacent houses.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 
// 👍 949 👎 0


package com.leewbl.leetcode.editor.cn;

import java.util.Arrays;

public class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            int[] nums1nm1 = Arrays.copyOfRange(nums, 0, length - 1);
            int[] nums2n = Arrays.copyOfRange(nums, 1, length);
            return Math.max(robrange(nums1nm1), robrange(nums2n));
        }
        public int robrange(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            if (length == 2) return Math.max(nums[0], nums[1]);
            if (length == 3) return Math.max(nums[0] + nums[2], nums[1]);
            int[] dp = new int[length];
            dp[0] = nums[0];
            dp[1] = nums[1];
            dp[2] = Math.max(nums[0] + nums[2], nums[1]);;
            for (int i = 3; i < length; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            }
            return Math.max(dp[length - 2], dp[length - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}