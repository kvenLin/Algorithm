import java.util.Arrays;

/**
 * @Author: clf
 * @Date: 18-12-23
 * @Description:
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0){
            return 0;
        }
        Arrays.sort(array);//顺序排序
        int len = array.length / 2;
        int tag = array[len];//标记元素,直接取这个元素进行计数,当存在超过一半长度的数则必定是这个数
        int count = 0;
        //校验tag元素是否符合条件
        for (int i = 0; i < array.length; i++) {
           if (array[i] == tag){
               count ++;
           }
        }
        return count > len ? tag : 0 ;
    }
}
