import java.util.ArrayList;

/**
 * @Author: clf
 * @Date: 18-11-27
 * @Description:
 * 题目描述
 * 输入一个整数数组，
 * 实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，
 * 偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    private final static int ODD_NUM = 1;//奇数

    public void reOrderArray(int [] array) {
        ArrayList<Integer> oddNums = new ArrayList<>();
        ArrayList<Integer> evenNums = new ArrayList<>();
        put(array, oddNums, evenNums);
        for (int i = 0; i < oddNums.size(); i++) {
            array[i] = oddNums.get(i);
        }
        for (int i = 0; i < evenNums.size(); i++) {
            //注意：这里是从第size所在的索引即为下一新元素的索引，不用进行-1操作
            array[oddNums.size() + i] = evenNums.get(i);
        }
    }

    private void put(int[] array, ArrayList oddNums, ArrayList evenNums){
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == ODD_NUM){
                oddNums.add(array[i]);
            }else {
                evenNums.add(array[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        new ReOrderArray().reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
