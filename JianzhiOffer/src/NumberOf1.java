/**
 * @Author: clf
 * @Date: 18-11-27
 * @Description:
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * java中的int用32为表示
 *
 * java中有三种移位运算符
 *
 * <<      :     左移运算符，num << 1,相当于num乘以2
 *
 * >>      :     右移运算符，num >> 1,相当于num除以2
 *
 * >>>    :     无符号右移，忽略符号位，空位都以0补齐
 *
 * 与运算： 0&0=0;  0&1=0;   1&0=0;    1&1=1;
 *
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            /**
             * 思路：
             * 因为存在负数，所以每一次都做无符号的移位以为运算，
             * 即忽略符号位，右移后都补0
             * n的二进制数右移每一低位都对1进行&操作判断是否为1
             */
            if ((n >>> i & 1) == 1){
                count ++;
            }
        }
        return count;
    }
}
