//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is i
//ncluded in the window. If there is no such substring, return the empty string ""
//. 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' fr
//om string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 105 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related Top
//ics 哈希表 字符串 滑动窗口 
// 👍 1243 👎 0


package com.leewbl.leetcode.editor.cn;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        solution.minWindow("abc", "ab");
        byte[] targetB = new byte[123];
        System.out.println(targetB);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int length = s.length();
            if (length == 0) {
                return "";
            } else {
                if (t.length() == 1) {
                    if (s.indexOf(t.charAt(0)) > -1) {
                        return t;
                    } else {
                        return "";
                    }
                }
            }
//            char[] chars = s.toCharArray();
//            char[] chart = t.toCharArray();
            int left = 0, right = 0;
            boolean found = false;
            int minLeft = 0, minRight = length - 1;
            int[] target = new int['z' + 1];
            for (char key : t.toCharArray()) {
                target[key] += 1;
            }
            int[] match = new int['z' + 1];
            match[s.charAt(0)] += 1;
            char checkL = 0;
            while (true) {
                boolean res = containSub(match, target, checkL);
                if (!res) {
                    if (++right >= length) {
                        break;
                    }
                    match[s.charAt(right)] += 1;
                } else {
                    found = true;
                    if (right - left < minRight - minLeft) {
                        minLeft = left;
                        minRight = right;
                    }
                    char cLeft = s.charAt(left);
                    match[cLeft] -= 1;
                    checkL = cLeft;
                    left++;
                }
            }
            if (found) {
                return s.substring(minLeft, minRight + 1);
            } else {
                return "";
            }

        }

        private boolean containSub(int[] match, int[] t, char checkL) {
            if (checkL > 0) {
                return match[checkL] >= t[checkL];
            }
            for (int i = 'A'; i <= 'z'; i++) {
                if (t[i] > match[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}