//Given two strings s and p, return an array of all the start indices of p's ana
//grams in s. You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s and p consist of lowercase English letters. 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 565 👎 0


package com.leewbl.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("cbaebabacd", "abc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int len = 'z' + 1;
            short[] target = new short[len];
            short[] match = new short[len];
            List<Integer> res = new ArrayList<>();
            int plen = p.length();
            int slen = s.length();
            if (slen<plen) return res;
            for (int i = 0; i < plen; i++) {
                target[p.charAt(i)]++;
            }
            for (int i = 0; i < plen; i++) {
                match[s.charAt(i)]++;
            }
            int left = 0;
            int right = plen - 1;
            while (left <= slen - plen) {
                if (contains(match, target)) {
                    res.add(left);
                }
                match[s.charAt(left)]--;
                left++;
                right++;
                if (right > slen - 1) {
                    break;
                }
                match[s.charAt(right)]++;
            }
            return res;
        }

        private boolean contains(short[] match, short[] target) {
            for (int i = 0; i < match.length; i++) {
                if (match[i] != target[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}