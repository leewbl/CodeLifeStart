//The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C
//', 'G', and 'T'. 
//
// 
// For example, "ACGAATTCCG" is a DNA sequence. 
// 
//
// When studying DNA, it is useful to identify repeated sequences within the DNA
//. 
//
// Given a string s that represents a DNA sequence, return all the 10-letter-lon
//g sequences (substrings) that occur more than once in a DNA molecule. You may re
//turn the answer in any order. 
//
// 
// Example 1: 
// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//Output: ["AAAAACCCCC","CCCCCAAAAA"]
// Example 2: 
// Input: s = "AAAAAAAAAAAAA"
//Output: ["AAAAAAAAAA"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s[i] is either 'A', 'C', 'G', or 'T'. 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 
// 👍 179 👎 0


package com.leewbl.leetcode.editor.cn;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

// A 0
// C 1
// G 2
// T 3
public class RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();
        solution.findRepeatedDnaSequences("AAAAAAAAAAA");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> list = new ArrayList<String>();
            int length = s.length();
            if (length < 10) {
                return list;
            }
            byte[] bytes = new byte[length];
            int[] showTimes = new int[1100000];
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (c == 'A') {
                    bytes[i] = 0;
                } else if (c == 'C') {
                    bytes[i] = 1;
                } else if (c == 'G') {
                    bytes[i] = 2;
                } else {
                    bytes[i] = 3;
                }
            }

            for (int i = 0; i <= length - 10; i++) {
                int tmp = construct(bytes, i);
                if (showTimes[tmp] >= 0) {
                    showTimes[tmp]++;
                    if (showTimes[tmp] > 1) {
                        list.add(convert(tmp));
                        showTimes[tmp] = -1;
                    }
                }
            }
            return list;
        }

        private int construct(byte[] bytes, int i) {
            int res = 0;
            for (int j = 0; j < 10; j++) {
                res = res * 4 + bytes[i + j];
            }
            return res;
        }

        private String convert(int tmp) {
            int cn = 10;
            int num = tmp;
            StringBuilder res = new StringBuilder();
            while (cn-- > 0) {
                int each = num % 4;
                if (each == 0) {
                    res.insert(0, 'A');
                } else if (each == 1) {
                    res.insert(0, 'C');
                } else if (each == 2) {
                    res.insert(0, 'G');
                } else {
                    res.insert(0, 'T');
                }
                num /= 4;
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}