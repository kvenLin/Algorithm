package suishou;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @Author: clf
 * @Date: 19-2-27
 * @Description:
 * 有一个多层有序Map嵌套结构，深度层次不可知，如何快速找出给定键名的第一个节点，例如从下图中找到第一个“warn”节点
 */
public class Exam2 {


    public static void test(String str, String letter) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if(Character.toUpperCase(letter.charAt(0)) ==  Character.toUpperCase(str.charAt(i))) {
                num++;
            }
        }
        System.out.println(num);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] coords = str.split(";");
        int x = 0, y = 0;
        for(String coord : coords) {
            if (Pattern.matches("^[A|S|W|D]\\d\\d?$", coord)) {
                char op = coord.charAt(0);
                Integer num = Integer.valueOf(coord.substring(1));
                switch (op){
                    case 'A':
                        x -= num;
                        break;
                    case 'W':
                        y += num;
                        break;
                    case 'S':
                        y -= num;
                        break;
                    case 'D':
                        x += num;
                }
            }
        }
        System.out.println(x + "," + y);
    }

}
