import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: clf
 * @Date: 18-12-20
 * @Description:
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 思路：
 * 1.把整个字符串视为第一个字符和后来的字符的字符的组合
 * 2.每次确定一个元素,和后面的元素一次兑换
 */
public class Permutation {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0){
            return list;
        }
        permutation(str.toCharArray(), 0, list);
        Collections.sort(list);//排序
        return list;
    }

    public void permutation(char[] chars, int i, ArrayList<String> list){
        if (i == chars.length - 1){
            String val = String.valueOf(chars);
            //去重
            if (!list.contains(val)){
                //将交换完的字符组合数组进行添加
                list.add(val);
            }
        }else {
            //前i个字符位置已经固定,对后面的字符进行组合
            for (int j = i; j < chars.length; j++) {
                //交换位置
                swap(chars, i, j);
                permutation(chars, i + 1, list);
                //还原之前的字符位置
                swap(chars, i, j);
            }
        }
    }

    public void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }



}
