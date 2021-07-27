//Given a string s consists of some words separated by spaces, return the length
// of the last word in the string. If the last word does not exist, return 0. 
//
// A word is a maximal substring consisting of non-space characters only. 
//
// 
// Example 1: 
// Input: s = "Hello World"
//Output: 5
// Example 2: 
// Input: s = " "
//Output: 0
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of only English letters and spaces ' '. 
// 
// Related Topics 字符串 
// 👍 336 👎 0


package com.leewbl.leetcode.editor.cn;
public class LengthOfLastWord{
  public static void main(String[] args) {
       Solution solution = new LengthOfLastWord().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        int idx = str.lastIndexOf(" ");
        return str.substring(idx + 1).length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}