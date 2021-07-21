//Given an integer array nums and an integer k, return true if there are two dis
//tinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <
//= k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1
//Output: true
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 0 <= k <= 105 
// 
// Related Topics 数组 哈希表 滑动窗口 
// 👍 286 👎 0


package com.leewbl.leetcode.editor.cn;

public class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        solution.containsNearbyDuplicate(new int[]{99, 99}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (nums.length == 1) {
                return k == 0;
            }
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}