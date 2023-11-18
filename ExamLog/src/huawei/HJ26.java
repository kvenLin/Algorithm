package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 *
 * 数据范围：输入的字符串长度满足
 *
 * 1≤n≤1000
 *
 * 输入描述：
 * 输入字符串
 * 输出描述：
 * 输出字符串
 * 示例1
 * 输入：
 * A Famous Saying: Much Ado About Nothing (2012/8).
 * 复制
 * 输出：
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */
public class HJ26 {

    public static String sort(String str) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                characters.add(str.charAt(i));
            }
        }
        characters.sort((o1, o2) -> {
            return Character.toLowerCase(o1) - Character.toLowerCase(o2);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                sb.append(characters.get(j));
                j++;
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(sort(str));

    }
}
