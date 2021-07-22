//Given two strings s1 and s2, return true if s2 contains the permutation of s1.
// 
//
// In other words, one of s1's permutations is the substring of s2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 and s2 consist of lowercase English letters. 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 381 👎 0


package com.leewbl.leetcode.editor.cn;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        solution.checkInclusion("ab", "asdfsad");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s2.length() < s1.length()) {
                return false;
            }
            int range = 'z' - 'a' + 1;
            int len = s1.length();
            int[] target = new int[range];
            int[] match = new int[range];
            int left = 0;
            for (int i = 0; i <= left + len - 1; i++) {
                int s1c = s1.charAt(i) - 'a';
                target[s1c]++;
                int s2c = s2.charAt(i) - 'a';
                match[s2c]++;
            }
            if (equal(match, target)) {
                return true;
            }

            while (left <= s2.length() - len - 1) {
                int lc = s2.charAt(left) - 'a';
                match[lc]--;
                left++;
                int rc = s2.charAt(left + len - 1) - 'a';
                match[rc]++;
                if (equal(match, target)) {
                    return true;
                }
            }
            return false;
        }

        private boolean equal(int[] match, int[] target) {
            for (int i = 0; i < 'z' - 'a'; i++) {
                if (match[i] != target[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}