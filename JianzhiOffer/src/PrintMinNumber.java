/**
 * @Author: clf
 * @Date: 18-12-27
 * @Description:
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    /**
     * 思路:
     * 冒泡排序,在遍历过程中进行按位比较
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        for (int i = 0; i < numbers.length; i++) {//遍历每一个数
            for (int j = i + 1; j < numbers.length; j++) {//将numbers[i]这个数和后面的每个数进行组合比较
                int a = Integer.parseInt(numbers[i] + "" + numbers[j]);
                int b = Integer.parseInt(numbers[j] + "" + numbers[i]);

                //将按位比较后按照小的结果进行位置调换
                if (a > b){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        String s = "";
        for (int i = 0; i < numbers.length; i++) {
            s += numbers[i];
        }
        return s;
    }
}
