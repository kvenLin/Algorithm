/**
 * @Author: clf
 * @Date: 18-11-26
 * @Description:
 * 题目描述
 * 请实现一个函数，
 * 将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String result = str.toString();
        if (result.contains(" ")) {
            while (str.indexOf(" ")!=str.lastIndexOf(" ")){
                int index = str.indexOf(" ");
                str.replace(index,index+1,"%20");
            }
            int index = str.indexOf(" ");
            str.replace(index,index+1,"%20");
            result = str.toString();
            return result;
        }else {
            return result;
        }
    }
}
