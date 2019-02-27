package suishou;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: clf
 * @Date: 19-2-27
 * @Description:
 * 如何在字符串中找到第一个不重复的字符(使用Java集合框架)
 */
public class Exam1 {
    public static char solution(String str){
        List<Character> noRepeat = new ArrayList<>();
        Set<Character> repeat = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (repeat.contains(c)){
                continue;
            }
            if (noRepeat.contains(c)){
                noRepeat.remove((Character) c);
                repeat.add(c);
            }else {
                noRepeat.add(c);
            }
        }
        return noRepeat.get(0);
    }
}
