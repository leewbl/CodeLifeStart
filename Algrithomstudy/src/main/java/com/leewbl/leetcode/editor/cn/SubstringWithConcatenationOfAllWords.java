//You are given a string s and an array of strings words of the same length. Ret
//urn all starting indices of substring(s) in s that is a concatenation of each wo
//rd in words exactly once, in any order, and without any intervening characters. 
//
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "barfoothefoobarman", words = ["foo","bar"]
//Output: [0,9]
//Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" re
//spectively.
//The output order does not matter, returning [9,0] is fine too.
// 
//
// Example 2: 
//
// 
//Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//Output: []
// 
//
// Example 3: 
//
// 
//Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//Output: [6,9,12]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of lower-case English letters. 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] consists of lower-case English letters. 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 502 👎 0


package com.leewbl.leetcode.editor.cn;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good", "best", "good"}));
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        System.out.println(solution.findSubstring("aa", new String[]{"a"}));
        System.out.println(solution.findSubstring("a", new String[]{"a"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int el = words[0].length();
            int al = words.length * el;
            int left = 0;
            int right = left + al -1;
            List<Integer> list = new ArrayList<Integer>();
            Map<String, Integer> target = new HashMap<String, Integer>();
            for (String e : words) {
                if (target.get(e) == null) {
                    target.put(e, 1);
                } else {
                    target.put(e, target.get(e) + 1);
                }
            }


            while (right < s.length()) {
                if (containsSub(s, left, right, el, target)) {
                    list.add(left);
                }
                right++;
                left++;
            }
            return list;

        }

        private boolean containsSub(String s, int left, int right, int el, Map<String, Integer> words) {
            Map<String, Integer> match = new HashMap<String, Integer>();
            for (int i = left; i <= right; i += el) {
                String e = s.substring(i, i + el);
                if (match.get(e) == null) {
                    match.put(e, 1);
                } else {
                    match.put(e, match.get(e) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry :
                    words.entrySet()) {
                if (!entry.getValue().equals(match.get(entry.getKey()))) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}