/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * 解题思路:
 * 从中心点往两边扩散，来寻找回文串，这种方向相当于穷举每一个点为中心点
 * 如果回文串是奇数时，比如 "bab" ，它的中心点就只有一个 "a"，所以从 "a" 开始向两边扩散
 * 如果回文串是偶数时，比如 "baab"，它的中心点有两个 "aa"，所以从 "aa" 开始向两边扩散
 * 编写一个辅助函数来寻找回文串，当中心点确定了之后调用辅助函数，直接返回找到的回文串
 * 将每次找到的回文串与之前的做对比，谁长就留谁
 *
 */
public class MaxEchoStr {
    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //存在奇数个的回文
            String s1 = findMaxStr(s, i, i);
            //存在偶数个的回文
            String s2 = findMaxStr(s, i, i + 1);
            //取最长的串
            // 三元运算符：判断为真时取冒号前面的值，为假时取冒号后面的值
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public static String findMaxStr(String s, int left, int right) {
        // 在区间 [0, s.length() - 1] 中寻找回文串，防止下标越界
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("tattarrattat"));
    }
}
