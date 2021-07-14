//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5729 👎 0


package com.leewbl.leetcode.editor.cn;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("pwwkew");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int left = 0, right = 1;
            int length = 1, max = 1;
            char[] chars = s.toCharArray();
            LinkedList<Character> characters = new LinkedList<Character>();
            characters.addFirst(chars[0]);
            while (right < chars.length) {
                char rightChar = chars[right];
                if (!characters.contains(rightChar)) {
                    // spread right
                    characters.addLast(rightChar);
                    length++;
                    if (length > max) {
                        max = length;
                    }
                    right++;
                } else {
                    characters.removeFirst();
                    length--;
                    if (!characters.contains(rightChar)) {
                        characters.addLast(rightChar);
                        right++;
                        length++;
                    }
                }

            }
            return max;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    // n^3
    class Solution0 {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int length = 1;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                boolean found = false;
                for (int j = 0; j <= chars.length - length; j++) {
                    if (isSubStringOfTarget(s, j, length)) {
                        found = true;
                        length++;
                        break;
                    }
                }
                if (!found || length == chars.length + 1) {
                    return length - 1;
                }
            }
            return -1;
        }

        private boolean isSubStringOfTarget(String string, int j, int length) {
            if (length == 1) {
                return true;
            }
            for (int i = j; i < j + length - 1; i++) {
                char ch = string.charAt(i);
                String s = string.substring(i + 1, j + length);
                if (s.indexOf(ch) != -1) {
                    return false;
                }
            }
            return true;
        }
    }

    // double pointer
    class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int left = 0, right = 1;
            int length = 1, max = 1;
            char[] chars = s.toCharArray();
            LinkedList<Character> characters = new LinkedList<Character>();
            characters.addFirst(chars[0]);
            while (right < chars.length) {
                char leftChar = chars[left];
                char rightChar = chars[right];
                if (!characters.contains(rightChar)) {
                    // spread right
                    characters.addLast(rightChar);
                    length++;
                    if (length > max) {
                        max = length;
                    }
                    right++;
                } else {
                    left++;
                    characters.removeFirst();
                    if (!characters.contains(rightChar)) {
                        characters.addLast(rightChar);
                    }
                }

            }
            return max;
        }

    }
}