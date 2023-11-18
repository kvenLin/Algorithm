package huawei;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 数据范围：保证结果在
 * 1
 * ≤
 * �
 * ≤
 * 2
 * 31
 * −
 * 1
 *
 * 1≤n≤2
 * 31
 *  −1
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 * 示例1
 * 输入：
 * 0xAA
 * 复制
 * 输出：
 * 170
 */
public class HJ5 {
    public static Map<Character, Integer> map = new HashMap();
    static {
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
    }

    public static Integer convert16to10(String str) {
        str = str.substring(2);
        Integer sum = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            Integer num = map.get(c);
            sum += (int) (Math.pow(16, str.length() - 1 - i)) * num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(convert16to10("0x2C"));
    }
}
