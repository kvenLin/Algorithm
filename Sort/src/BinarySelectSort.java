/**
 * @Author: clf
 * @Date: 19-3-16
 * @Description:
 * 折半插入排序
 * 思路：
 * 插入排序的基础上使用折半查找算法来寻找插入的位置，
 * 即因为在当前元素位置前面的所有元素的序列都是已经排好的序列，
 * 所以使用值班查找可以加快查询速度。
 */
public class BinarySelectSort {
    public static void main(String[] args) {
        int a[] = new int[]{5, 2, 56, 8, 15, 3, 4, 1, 0};
        sort(a);
        printArr(a);
    }

    /**
     * 升序的折半插入排序
     * @param arr
     */
    public static void sort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];//暂存当前元素的值
            int low = 0;//标记最低位
            int high = i - 1;//标记当前位置
            while (low <= high){
                int middle = (low + high) / 2;//获取中间元素
                if (arr[middle] < currentValue){//middle左侧的值都比当前值小，即只需要从middle右侧寻找
                    low = middle + 1;//标记middle右侧的低位
                }else {
                    high = middle - 1;
                }
            }
            //二分查找完成后满足此时low = high + 1
            int index = i - 1;//获取当前元素的前一个位置
            //将从arr[low]开始的(i - low)个元素，都向后移动一位
            while (index >= low){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[low] = currentValue;
        }
    }

    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
