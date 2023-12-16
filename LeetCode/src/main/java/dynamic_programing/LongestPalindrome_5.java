package dynamic_programing;

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
 */
public class LongestPalindrome_5 {

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n==1) {
            return s;
        }
        String max = "";
        for (int i = 0; i + 1 < n; i++) {
            String s1 = maxLongPalindrome(s, i, i);
            String s2 = maxLongPalindrome(s, i, i + 1);
            max = max.length() > s1.length() ? max : s1;
            max = max.length() > s2.length() ? max : s2;
        }
        return max;
    }

    public String maxLongPalindrome(String s, int center1, int center2) {
        if (center1 != center2 && s.charAt(center1) != s.charAt(center2)) {
            return "";
        }
        StringBuilder maxLen = new StringBuilder();
        for (int i = 1; i <= center1 && center2 + i < s.length(); i++) {
            if (s.charAt(center1 - i) == s.charAt(center2 + i)) {
                //左右相等, 取右半边
                maxLen.append(s.charAt(center2 + i));
            }else {
                break;
            }
        }
        String s1 = new StringBuilder(maxLen.toString()).reverse().toString();
        String s2 = maxLen.toString();
        char c1 = s.charAt(center1);
        char c2 = s.charAt(center2);
        String res = center1 == center2 ?  s1 + c1 + s2 : s1 +  c1 + c2 + s2;
        return res.length() == 0 ? s.charAt(center1) + "" : res;
    }

    public static void main(String[] args) {
        LongestPalindrome_5 palindrome5 = new LongestPalindrome_5();
        System.out.println(palindrome5.longestPalindrome("ac"));
    }

}
