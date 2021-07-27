//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lower-case English letters. 
// 
// Related Topics 字符串 
// 👍 1703 👎 0


package com.leewbl.leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String firstStr = strs[0];
            int length = firstStr.length();
            int i = 0;
            for (; i < length; i++) {
                if (!allContains(strs, i, firstStr.charAt(i))) {
                    return firstStr.substring(0, i);
                }
            }
            return firstStr.substring(0, i);
        }

        private boolean allContains(String[] strs, int i, char c) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}