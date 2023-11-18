import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class PhoneAlphabetCombine {

    public static List<String> letterCombinations(String digits) {
        String[] numMap = new String[]{
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        List<String> res = new ArrayList<>();
        concatStr(res, numMap, digits, 0);
        return res;
    }

    public static void concatStr(List<String> list, String[] numMap, String digits, Integer deep) {
        if (deep > digits.length() - 1) {
            return;
        }
        Integer index = Integer.valueOf(Character.toString(digits.charAt(deep)));
        String s = numMap[index];
        for (int i = 0; i < s.length(); i++) {
            String s1 = Character.toString(s.charAt(i));
            for (String s2 : list) {
                s2 = s1 + s2;
            }
        }
        concatStr(list, numMap, digits, deep++);
    }

    public static void main(String[] args) {
        List<String> res = letterCombinations("23");
        System.out.println(res.toArray());
    }
}
