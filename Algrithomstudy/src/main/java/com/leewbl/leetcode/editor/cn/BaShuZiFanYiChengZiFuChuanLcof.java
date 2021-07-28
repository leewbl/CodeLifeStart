//English description is not available for the problem. Please switch to Chinese
//. Related Topics 字符串 动态规划 
// 👍 255 👎 0


package com.leewbl.leetcode.editor.cn;

public class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        solution.translateNum(258);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            int sn1 = 0;
            int sn = 0;
            int cn = 1;
            int cn1 = 1;
            int cn2 = 0;
            for (; num!=0;) {
                sn1 = num%10;
                if (sn1 == 1 || (sn1 == 2 && sn <= 5)) {
                    cn = cn1 + cn2;
                }
                sn = sn1;
                cn2 = cn1;
                cn1 = cn;
                num = (num - sn1) / 10;
            }
            return cn;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}